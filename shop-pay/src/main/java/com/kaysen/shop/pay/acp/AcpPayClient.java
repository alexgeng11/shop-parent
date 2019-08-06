package com.kaysen.shop.pay.acp;

import com.alibaba.fastjson.JSON;
import com.kaysen.shop.pay.acp.sdk.AcpService;
import com.kaysen.shop.pay.acp.sdk.SDKConfig;
import com.lfm.pay.utils.PayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * 银联支付客户端
 */
public class AcpPayClient {

    private HashMap<String,String> commonMap;

    private static Logger logger = LoggerFactory.getLogger(AcpPayConfig.class);
    private SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 初始化公共参数
     * @param commonMap 公共参数,在AcpPayConfig中配置
     */
    public AcpPayClient(HashMap<String, String> commonMap) {
        this.commonMap = commonMap;
    }
    
    /**  
    * @Title: gatewayPay  
    * @Description: 网关支付
    * @param @param paramMap
    * @param @return
    * @return String 
    * @throws  
    */ 
    public String gatewayPay(Map<String, String> paramMap){
    	SDKConfig.getConfig().loadPropertiesFromSrc();
        paramMap.putAll(commonMap);
        paramMap.put("txnType", "01");//交易类型必填取值：01
        paramMap.put("txnSubType", "01");//交易子类必填取值：01：自助消费，通过地址的方式区分前台消费和后台消费（含无跳转支付） 03：分期付款
        paramMap.put("txnTime", PayUtils.getSdfTimes());//订单发送时间 必填商户发送交易时间
//        paramMap.put("riskRateInfo", "{commodityName=ceshi}");//风控信息域 选填
        paramMap.put("frontUrl", AcpPayConfig.FRONTURL);//前台通知地址 按条件必填前台返回商户结果时使用，前台类交易需上送 不支持换行符等不可见字符
        paramMap.put("backUrl", AcpPayConfig.BACKURL);//后台通知地址 必填 后台返回商户结果时使用，如上送，则发送商户后台交易结果通知，如果不需要发后台通知，可以固定上送http://www.specialUrl.com
        paramMap.put("payTimeout",simpleDateFormat.format(System.currentTimeMillis() + 15 * 60 * 1000));//支付超时时间 选填 超过此时间用户支付成功的交易，不通知商户，系统自动退款，大约5个工作日金额返还到用户账户
        paramMap.put("txnAmt",paramMap.get("txnAmt"));//交易金额 必填 单位为分
        paramMap.put("orderId",paramMap.get("orderId"));//商户订单号 必填
        paramMap.put("merId","777290058169089");//商户代码 必填
        paramMap.put("version","5.1.0");//版本号 必填 固定填写5.1.0
        //是否加密取决于商户是否开通了隐私加密权限
//      paramMap.put("customerInfo",AcpService.getCustomerInfoWithEncrypt(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        Map<String, String> reqData = AcpService.sign(paramMap,AcpPayConfig.ENCODING_UTF8); //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        logger.info("银联请求签名======={}", JSON.toJSONString(reqData));
        String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();     //获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
        String html = AcpService.createAutoFormHtml(requestFrontUrl,reqData,AcpPayConfig.ENCODING_UTF8);     //生成自动跳转的Html表单
        logger.debug("银联请求:"+html);
        return html;
    }
    
    /**  
	* @Title: gateAppWayPay  
	* @Description: app支付
	* @param @param paramMap
	* @param @return
	* @return String 
	* @throws  
	*/ 
	public String gateAppWayPay(Map<String, String> paramMap) {
		SDKConfig.getConfig().loadPropertiesFromSrc();
        paramMap.putAll(commonMap);
        paramMap.put("txnTime", PayUtils.getSdfTimes());
        paramMap.put("txnType", "01"); //交易类型 ，01：消费
        paramMap.put("txnSubType", "01");  //交易子类型， 01：自助消费
        paramMap.put("channelType", "07");  //渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板  08：手机
        paramMap.put("bizType", "000201");  //业务类型，B2C网关支付，手机wap支付
        paramMap.put("frontUrl", AcpPayConfig.FRONTURL);
        paramMap.put("backUrl", AcpPayConfig.BACKURL);
        paramMap.put("txnAmt",paramMap.get("txnAmt"));
        paramMap.put("orderId",paramMap.get("orderId"));
        paramMap.put("riskRateInfo",paramMap.get("riskRateInfoc"));
        paramMap.put("payTimeout", new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis() + 20 * 60 * 1000));
        //是否加密取决于商户是否开通了隐私加密权限
//      paramMap.put("customerInfo",AcpService.getCustomerInfoWithEncrypt(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        Map<String, String> reqData = AcpService.sign(paramMap,AcpPayConfig.ENCODING_UTF8); //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。 	
        logger.info("银联请求签名======={}",JSON.toJSONString(reqData));
        String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();    						 //获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
        String html = AcpService.createAutoFormHtml(requestFrontUrl,reqData,AcpPayConfig.ENCODING_UTF8);     //生成自动跳转的Html表单
        logger.debug("银联请求:"+html);
        return html;
	}

    /**
     * 开通token请求
     * @param paramMap 要传送的参数
     * @return 生成的form表单
     */
    public String tokenOpen(Map<String, String> paramMap,Map<String, String> customerInfo){
        paramMap.putAll(commonMap);
        paramMap.put("txnTime", PayUtils.getSdfTimes());
        paramMap.put("txnType", "79");
        paramMap.put("txnSubType", "00");
        paramMap.put("frontUrl", AcpPayConfig.FRONTURL);
        paramMap.put("backUrl", AcpPayConfig.BACKURL);
        paramMap.put("tokenPayData", AcpPayConfig.TOKENPAYDATA);
        paramMap.put("customerInfo",AcpService.getCustomerInfo(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        //是否加密取决于商户是否开通了隐私加密权限
//      paramMap.put("customerInfo",AcpService.getCustomerInfoWithEncrypt(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        Map<String, String> reqData = AcpService.sign(paramMap,AcpPayConfig.ENCODING_UTF8);  			 //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl();    						 //获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
        String html = AcpService.createAutoFormHtml(requestFrontUrl,reqData,AcpPayConfig.ENCODING_UTF8);     //生成自动跳转的Html表单
        logger.debug("银联token请求:"+html);
        return html;
    }
    
    
    
    /**
     * 请求银联发送消费短信
     * @param paramMap 要传送的参数
     * @return 请求返回的结果
     */
    public Map<String, String> msgSend(Map<String, String> paramMap,Map<String, String> customerInfo){
        paramMap.putAll(commonMap);
        paramMap.put("txnType", "77");
        paramMap.put("txnTime", PayUtils.getSdfTimes());
        paramMap.put("customerInfo",AcpService.getCustomerInfo(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        //是否加密取决于商户是否开通了隐私加密权限
//      paramMap.put("customerInfo",AcpService.getCustomerInfoWithEncrypt(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        Map<String, String> reqData = AcpService.sign(paramMap,AcpPayConfig.ENCODING_UTF8);			 //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        String requestBackUrl = SDKConfig.getConfig().getBackRequestUrl();   								 //交易请求url从配置文件读取对应属性文件acp_sdk.properties中的 acpsdk.backTransUrl
        Map<String, String> rspData = AcpService.post(reqData,requestBackUrl,AcpPayConfig.ENCODING_UTF8);
        logger.debug("银联短信请求结果:"+rspData.toString());
        return rspData;
    }

    /**
     * 消费请求
     * @param paramMap 需要传送的参数
     * @return 请求结果,消费结果返回异步通知
     */
    public Map<String,String> consume(Map<String, String> paramMap,Map<String, String> customerInfo){
        paramMap.putAll(commonMap);
        paramMap.put("txnType", "01");
        paramMap.put("frontUrl", AcpPayConfig.FRONTURL);
        paramMap.put("backUrl", AcpPayConfig.CONSUME_BACKURL);
        paramMap.put("customerIp", "127.0.0.1");
        paramMap.put("txnTime", PayUtils.getSdfTimes());
        paramMap.put("customerInfo",AcpService.getCustomerInfo(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        //是否加密取决于商户是否开通了隐私加密权限
//      paramMap.put("customerInfo",AcpService.getCustomerInfoWithEncrypt(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        Map<String, String> reqData = AcpService.sign(paramMap,AcpPayConfig.ENCODING_UTF8);				//报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        String requestBackUrl = SDKConfig.getConfig().getBackRequestUrl();   							//交易请求url从配置文件读取对应属性文件acp_sdk.properties中的 acpsdk.backTransUrl
        Map<String, String> rspData = AcpService.post(reqData,requestBackUrl,AcpPayConfig.ENCODING_UTF8);	//发送请求报文并接受同步应答（默认连接超时时间30秒，读取返回结果超时时间30秒）;这里调用signData之后，调用submitUrl之前不能对submitFromData中的键值对做任何修改，如果修改会导致验签不通过
        logger.debug("银联消费请求结果:"+rspData.toString());
        return rspData;
    }

    /**
     * 交易退货类请求
     * @param paramMap 退货请求参数
     * @return 退货结果
     */
    public Map<String,String> refund(Map<String, String> paramMap){
        SDKConfig.getConfig().loadPropertiesFromSrc();
        paramMap.putAll(commonMap);
        paramMap.put("txnType", "04"); //交易类型 ，04：退款
        paramMap.put("txnSubType", "00");  //交易子类型， 必填 默认：00
        paramMap.put("txnTime", PayUtils.getSdfTimes());//订单发送时间，必填
        paramMap.put("backUrl", AcpPayConfig.BACKURL);//后台通知地址
        paramMap.put("txnAmt",paramMap.get("txnAmt"));//退款金额	必填
        paramMap.put("orderId",paramMap.get("orderId"));//商户订单号，必填，商户订单号，不能含“-”或“_”; 商户自定义，同一交易日期内不可重复; 商户代码merId、商户订单号orderId、订单发送时间txnTime三要素唯一确定一笔交易。
        paramMap.put("origQryId",paramMap.get("origQryId"));//原交易查询流水号，必填，原始消费交易的queryId
        //是否加密取决于商户是否开通了隐私加密权限
//      paramMap.put("customerInfo",AcpService.getCustomerInfoWithEncrypt(customerInfo,paramMap.get("accNo"),AcpPayConfig.ENCODING_UTF8));
        Map<String, String> reqData = AcpService.sign(paramMap,AcpPayConfig.ENCODING_UTF8); //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        String url = SDKConfig.getConfig().getBackRequestUrl();
        Map<String, String> rspData = AcpService.post(reqData, url,AcpPayConfig.ENCODING_UTF8);
        /**对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考------------->**/
        //应答码规范参考open.unionpay.com帮助中心 下载  产品接口规范  《平台接入接口规范-第5部分-附录》
        if(!rspData.isEmpty()){
            if(AcpService.validate(rspData, AcpPayConfig.ENCODING_UTF8)){
                logger.info("验证签名成功");
                String respCode = rspData.get("respCode");
                if("00".equals(respCode)){
                    //交易已受理，等待接收后台通知更新订单状态,也可以主动发起 查询交易确定交易状态。
                    //TODO
                }else if("03".equals(respCode)||
                        "04".equals(respCode)||
                        "05".equals(respCode)){
                    //后续需发起交易状态查询交易确定交易状态
                    //TODO
                }else{
                    //其他应答码为失败请排查原因
                    //TODO
                }
            }else{
                logger.info("验证签名失败");
                //TODO 检查验证签名失败的原因
            }
        }else{
            //未返回正确的http状态
            logger.info("未获取到返回报文或返回http状态码非200");
        }
        logger.info(JSON.toJSONString(rspData));
        return rspData;
    }

	
}
