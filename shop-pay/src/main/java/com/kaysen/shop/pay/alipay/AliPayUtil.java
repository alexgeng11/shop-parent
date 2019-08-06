/**  
* @Title: AliPayUtil.java  
* @Package com.lfm.com.lfm.pay.alipay
* @Description: TODO  
* @author lujun  
* @date 2018年5月15日  
* @version V1.0  
*/ 
package com.kaysen.shop.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.lfm.pay.utils.PayUtils;
import com.lfm.pay.utils.WebPropertyHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;


/**  
* @ClassName: AliPayUtil  
* @Description: TODO 
* @author lujun  
* @date 2018年5月15日    
*/
public class AliPayUtil {
	
	private static Logger logger=LoggerFactory.getLogger(AliPayUtil.class);

	private static AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json",AlipayConfig.charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
	
	@SuppressWarnings("rawtypes")
	public static String aliPayPrecreate(Map<String, Object> otherParams) throws AlipayApiException {
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.setNotifyUrl(AlipayConfig.notify_url);
		request.setBizContent(PayUtils.objectToJson(buildAliBizParams(otherParams)));
		AlipayTradePrecreateResponse response = alipayClient.execute(request);
		if(response.isSuccess()){
			logger.info("Alipay 预支付 调用成功======{}",response.getBody());
			Map returnMap=PayUtils.jsonToPojo(response.getBody(), Map.class);
			Map map2=(Map) returnMap.get("alipay_trade_precreate_response");
			return map2.get("qr_code").toString();
		}
		logger.info("Alipay 预支付 调用失败======"+JSON.toJSONString(response));
		return null;
	}
	
	public static Map aliAppPayPrecreate(Map<String, Object> otherParams) throws AlipayApiException {
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		request.setNotifyUrl(AlipayConfig.notify_url);
		request.setBizContent(PayUtils.objectToJson(buildAliBizParams(otherParams)));
		AlipayTradeAppPayResponse response = alipayClient.pageExecute(request);
		if(response.isSuccess()){
			logger.info("AliApppay 预支付 调用成功======{}",response.getBody());
			Map<String,Object> returnMap=new HashMap<String,Object>();
			String body = response.getBody();
			returnMap.put("body", body);
			return returnMap;
		}
		logger.info("AliApppay 预支付 调用失败======"+JSON.toJSONString(response));
		return null;
	}
	
	
	public static Map aliAppPayPrecreate2(Map<String, Object> otherParams) throws AlipayApiException {
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		request.setNotifyUrl(WebPropertyHolder.getAlipay_notify_url3());
		request.setBizContent(PayUtils.objectToJson(buildAliBizParams(otherParams)));
		AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
		if(response.isSuccess()){
			logger.info("AliApppay 预支付 调用成功======{}",response.getBody());
			Map<String,Object> returnMap=new HashMap<String,Object>();
			String body = response.getBody();
			returnMap.put("body", body);
			String[] bodyArr = body.split("&");
			returnMap.put("bodyArr", bodyArr);
			return returnMap;
		}
		logger.info("AliApppay 预支付 调用失败======"+JSON.toJSONString(response));
		return null;
	}
	
	public static Map aliWapPayPrecreate(Map<String, Object> otherParams) throws AlipayApiException {
		AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
		request.setReturnUrl(AlipayConfig.api_return_url);
		request.setNotifyUrl(AlipayConfig.api_notify_url);
		request.setBizContent(PayUtils.objectToJson(buildAliBizParams(otherParams)));
		AlipayTradeWapPayResponse response = alipayClient.pageExecute(request);
		if(response.isSuccess()){
			logger.info("AliApppay 预支付 调用成功======{}",response.getBody());
			Map<String,Object> returnMap=new HashMap<String,Object>();
			String body = response.getBody();
			returnMap.put("body", body);
			return returnMap;
		}
		logger.info("AliApppay 预支付 调用失败======"+JSON.toJSONString(response));
		return null;
	}
	
	
	public static Boolean aliPayRefund(Map<String, Object> otherParams) throws AlipayApiException {
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		request.setNotifyUrl(AlipayConfig.notify_url);
		request.setBizContent(PayUtils.objectToJson(buildAliBizRefundParams(otherParams)));
		AlipayTradeRefundResponse response = alipayClient.execute(request);
		if(response.isSuccess()){
			logger.info("退款调用成功======{}",response.getBody());
			Map returnMap=PayUtils.jsonToPojo(response.getBody(), Map.class);
			Map map2=(Map) returnMap.get("alipay_trade_precreate_response");
			return true;
		}
		if("40004".equals(response.getCode())){
			return null;
		}
		logger.info("Alipay 退款 调用失败======"+JSON.toJSONString(response));
		return false;
	}
	
	public static Map<String, Object> buildAliBizParams(Map<String, Object> otherParams){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("out_trade_no", otherParams.get("out_trade_no"));
		params.put("total_amount", otherParams.get("total_amount"));
		params.put("subject", otherParams.get("subject"));
		return params;
	}

	
	public static Map<String, Object> buildAliBizRefundParams(Map<String, Object> otherParams){
		Map<String, Object> params=new HashMap<String, Object>();
//		params.put("out_trade_no", otherParams.get("out_trade_no"));
		params.put("trade_no", otherParams.get("trade_no"));
		params.put("refund_amount", otherParams.get("refund_amount"));
//		params.put("out_request_no", otherParams.get("out_request_no"));
		params.put("refund_reason", otherParams.get("refund_reason"));
		return params;
	}
	

	
	public static boolean AlipayTradeCancel(Map<String, Object> params) throws AlipayApiException {
		if (!CollectionUtils.isEmpty(params)) {
			AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
			request.setBizContent(PayUtils.objectToJson(buildAliBizParams(params)));
			AlipayTradeCancelResponse response = alipayClient.execute(request);
			if (response.isSuccess()) {
				logger.info("交易撤销成功.");
				return true;
			} else {
				logger.info("交易撤销失败.");
				return false;
			}
		}
		return true;
	}
	
	

}