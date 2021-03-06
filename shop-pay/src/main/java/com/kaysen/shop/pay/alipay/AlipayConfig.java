/**  
* @Title: AlipayConfig.java  
* @Package com.lfm.com.lfm.pay.alipay
* @Description: TODO  
* @author lujun  
* @date 2018年5月15日  
* @version V1.0  
*/ 
package com.kaysen.shop.pay.alipay;

import com.lfm.pay.utils.WebPropertyHolder;

/**
* @ClassName: AlipayConfig  
* @Description: 基础配置类
* @author lujun  
* @date 2018年5月15日    
*/
public class AlipayConfig {
	
		// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		public static String app_id = WebPropertyHolder.getAliAppid();
		
		// 商户私钥，您的PKCS8格式RSA2私钥
	    public static String merchant_private_key = WebPropertyHolder.getMerchant_private_key();
	   
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    public static String alipay_public_key = WebPropertyHolder.getAlipay_public_key();
	   
		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	    public static String notify_url = WebPropertyHolder.getAlipay_notify_url();
	    public static String api_notify_url = WebPropertyHolder.getAlipay_notify_url();
	    public static String api_return_url = WebPropertyHolder.getAlipay_return_url();

		// 签名方式
		public static String sign_type = "RSA2";
		
		// 字符编码格式
		public static String charset = "utf-8";
		
		// 支付宝网关
		public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

}
