/**  
* @Title: WxpayUtil.java  
* @Package com.lfm.com.lfm.pay.wxpay
* @Description: TODO  
* @author lujun  
* @date 2018年5月15日  
* @version V1.0  
*/ 
package com.kaysen.shop.pay.wxpay;

import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.lfm.pay.utils.PayUtils;
import com.lfm.pay.utils.WebPropertyHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;


/**  
* @ClassName: WxpayUtil  
* @Description: 支付工具类
* @author lujun  
* @date 2018年5月15日    
*/
public class WxpayUtil {
	
	private static Logger logger=LoggerFactory.getLogger(WxpayUtil.class);
	
	
	
	/**
	 * 
	 * @Description: 统一下单参数构建
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author Frank.Hou
	 * @date 2017年12月14日
	 * @throws Exception 
	 */
	public static String wxPayPrecreate(Map<String, Object> params) throws Exception{
		Map<String, String> buildMap=new HashMap<String, String>();
		buildMap.put("body", params.get("body").toString());
		buildMap.put("out_trade_no", params.get("out_trade_no").toString());
		buildMap.put("total_fee", String.valueOf(params.get("total_fee")));//数据库保存分
		buildMap.put("spbill_create_ip", params.get("spbill_create_ip").toString());
		buildMap.put("notify_url", WebPropertyHolder.getWechatNotify());
		buildMap.put("trade_type", "NATIVE");
		buildMap.put("product_id", params.get("product_id").toString());
		WxpayConfig config = WxpayConfig.getInstance();
        WXPay wxpay = new WXPay(config);
        Map<String, String> reqData=wxpay.fillRequestData(buildMap);
        logger.info("请求统一下单参数为============={}/n 对应xml为===={}",PayUtils.objectToJson(reqData), WXPayUtil.mapToXml(reqData));
		Map<String, String> unifedData=wxpay.unifiedOrder(reqData);
		logger.info("统一下单返回参数为============={}",PayUtils.objectToJson(unifedData));
		return getWechatQrcodeUri(unifedData);
	}

	/**
	 * 微信app支付
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> wxAppPayPrecreate(Map<String, Object> params) throws Exception{
		Map<String, String> buildMap=new HashMap<String, String>();
		buildMap.put("body", params.get("body").toString());
		buildMap.put("out_trade_no", params.get("out_trade_no").toString());
		buildMap.put("total_fee", String.valueOf(params.get("total_fee")));//数据库保存分
		buildMap.put("spbill_create_ip", params.get("spbill_create_ip").toString());
		buildMap.put("notify_url", WebPropertyHolder.getWechatAppNotify3());
		buildMap.put("trade_type", "APP");
		WxAppPayConfig config =WxAppPayConfig.getInstance();
		System.err.println("配置信息为================="+JSON.toJSONString(config));
		logger.info("配置信息为================="+JSON.toJSONString(config));
        WXPay wxpay = new WXPay(config);
        Map<String, String> reqData=wxpay.fillRequestData(buildMap);
        logger.info("请求统一下单参数为============={}/n 对应xml为===={}",PayUtils.objectToJson(reqData), WXPayUtil.mapToXml(reqData));
		Map<String, String> unifedData=wxpay.unifiedOrder(reqData);
		logger.info("统一下单返回参数为============={}",PayUtils.objectToJson(unifedData));
		return unifedData;
	}

	/**
	 * 微信小程序支付
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> wxJSAPIPayPrecreate(Map<String, Object> params) throws Exception{
		Map<String, String> buildMap=new HashMap<String, String>();
		buildMap.put("body", params.get("body").toString());
		buildMap.put("out_trade_no", params.get("out_trade_no").toString());
		buildMap.put("total_fee", String.valueOf(params.get("total_fee")));//数据库保存分
		buildMap.put("spbill_create_ip", params.get("spbill_create_ip").toString());
		buildMap.put("notify_url", WebPropertyHolder.getWechatAppNotify3());
		buildMap.put("trade_type", "JSAPI");
		buildMap.put("openid", "wx48adcdd32004715c");
		WxpayConfig config =WxpayConfig.getInstance();
		System.err.println("配置信息为================="+JSON.toJSONString(config));
		logger.info("配置信息为================="+JSON.toJSONString(config));
        WXPay wxpay = new WXPay(config);
        Map<String, String> reqData=wxpay.fillRequestData(buildMap);
        logger.info("请求统一下单参数为============={}/n 对应xml为===={}",PayUtils.objectToJson(reqData), WXPayUtil.mapToXml(reqData));
		Map<String, String> unifedData=wxpay.unifiedOrder(reqData);
		logger.info("统一下单返回参数为============={}",PayUtils.objectToJson(unifedData));
		return unifedData;
	}


	/**
	 * 微信退款
	 * @param params
	 * @param filePath
	 * @return
	 */
	public static boolean  wxPayRefund(Map<String, Object> params,String filePath){
		try {
			Map<String, String> buildMap=new HashMap<String, String>();
			buildMap.put("transaction_id", params.get("transaction_id").toString());
			buildMap.put("out_trade_no", params.get("out_trade_no").toString());
			buildMap.put("out_refund_no", params.get("out_refund_no").toString());
			buildMap.put("refund_fee", params.get("refund_fee").toString());
			buildMap.put("total_fee", String.valueOf(params.get("total_fee")));//数据库保存分
			buildMap.put("refund_desc", params.get("refund_desc").toString());
			buildMap.put("notify_url", WebPropertyHolder.getWechatNotify());
			WxpayConfig config =WxpayConfig.getInstance(filePath);
			WXPay wxpay = new WXPay(config);
			Map<String, String> reqData=wxpay.fillRequestData(buildMap);
			logger.info("微信退款参数为============={}/n 对应xml为===={}",PayUtils.objectToJson(reqData), WXPayUtil.mapToXml(reqData));
			Map<String, String> refundData=wxpay.refund(reqData);
			logger.info("微信退款返回参数为============={}",PayUtils.objectToJson(refundData));
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}

	}
	
	public static Map<String, String> convertMap(Map<String, Object> params){
		Map<String, String> result=new HashMap<String, String>();
		if(!CollectionUtils.isEmpty(params)){
			for (Map.Entry<String, Object> param: params.entrySet()) {
				String value = String.valueOf(param.getValue());
				result.put(param.getKey(), value);
			}
			return result;
		}
		return null;
	}
	
	public static final String PREPAY_ID="prepay_id";//预支付id key
	
	
	
	public static String preNotifyDto(String return_code,String err_code_des,String prepay_id) throws Exception{
		Map<String, String> returnMap=new HashMap<String, String>();
		returnMap.put(PREPAY_ID, prepay_id);
		returnMap.put("return_code", return_code);
		returnMap.put("err_code_des", err_code_des);
		returnMap.put("result_code", return_code);
		WxpayConfig config =WxpayConfig.getInstance();
        WXPay wxpay = new WXPay(config);
        Map<String, String> reqData=wxpay.fillRequestData(returnMap);
        return WXPayUtil.mapToXml(reqData);
	}
	
	
	
	public static String getWechatQrcodeUri(Map<String, String> undReturnMap){
		if("SUCCESS".equalsIgnoreCase(undReturnMap.get("return_code").toString())
				&& "SUCCESS".equalsIgnoreCase(undReturnMap.get("result_code").toString())){
			logger.info("统一下单成功-----------{}",System.currentTimeMillis());
			String qrcodeContent=undReturnMap.get("code_url")==null? "" :undReturnMap.get("code_url");
			return qrcodeContent;
		}else{
			logger.error("统一下单失败-----------{}",System.currentTimeMillis());
			return null;
		}
	}

	/**
	 * 关闭交易
	 * @param parameters
	 * @throws Exception
	 */
	public static void wechatTradeCancel(Map<String, Object> parameters) throws Exception{
		if(!CollectionUtils.isEmpty(parameters)){
			WxpayConfig config =WxpayConfig.getInstance();
	        WXPay wxpay = new WXPay(config);
	        Map<String, String> reqData=new HashMap<String, String>();
	        reqData.put("out_trade_no", parameters.get("out_trade_no").toString());
	        Map<String, String> requestMap=wxpay.fillRequestData(reqData);
	        Map<String, String> returnMap=wxpay.closeOrder(requestMap);
	        if(returnMap.get("return_code").equalsIgnoreCase(WXPayConstants.SUCCESS)){
	        	logger.info("微信关闭订单成功.----------------{}",returnMap.get("return_msg"));
	        }else{
	        	logger.error("微信关闭订单失败.----------------{}",returnMap.get("return_msg"));
	        }
		}
	}
	

}
