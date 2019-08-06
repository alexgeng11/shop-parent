package com.lfm.pay.utils;


import org.springframework.beans.factory.annotation.Value;

/**
* @ClassName: WebPropertyHolder  
* @Description: 全局变量 使用加载配置文件方式获取
* @author lujun  
* @date 2018年5月15日    
*/ 
public class WebPropertyHolder {
	
	
	private static String wechatAppid="wx48adcdd32004715c";
	
	private static String wechatkey="8A1E6A6F80DD54C69D2FCA28BE3795C1";
	
	private static String wechatmchid="1496157092";

	private static String wechatNotify="http://115.47.154.137:8085/front/notify/wechat";
	
	private static String wechatNotify2="http://115.47.154.137:8085/front/payback/wechat";
	
	
	private static String wechatAppAppid="wx6edd5c1b6f7db8eb";
	
	private static String wechatAppkey="airuizhi01065885188ismarthealth1";
	
	private static String wechatAppmchid="1509198611";

	private static String wechatAppNotify="http://arz.ctq100.com/front/notify/wechat";
	
	private static String wechatAppNotify2="http://arz.ctq100.com/front/payback/wechat";
	private static String wechatAppNotify3="http://arz.ctq100.com/apiv1-1/notify/wechat";
	
	public static String getWechatAppNotify3() {
		return wechatAppNotify3;
	}
	
	@Value("${wechatApp.notify.url3}")
	public  void setWechatAppNotify3(String wechatAppNotify3) {
		WebPropertyHolder.wechatAppNotify3 = wechatAppNotify3;
	}

	private static String aliAppid="2019050664390020";
	
	private static String merchant_private_key="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDW3C6iu62EQKUd" +
			"MLGDw0n1+FPw3KtysXYKPWPRUuNUozF6FLgeXG6Y3gfMe2xsmUO6WQAxFcK9r/Qm" +
			"OnBx0PlGFN2tlMgzhdfTckSU5uLzZhru4KfTcy/BWcif/vdpb3/2kXnVXRgvBn7b" +
			"DagAIvu4Xtgrom92IFvKeV3zf5wRGy1B4yOc61wBJYJ2eZTeGz5wmpwFDhLBw1xE" +
			"NU462S3zZGTjskp5UhbMU8CU+qFyTlAQV/FpnuD1D1pFZmKP/tbwjst/Mj59vj2j" +
			"XTYpENhzfm6Fsa8Mn/1RWnXn9KWO+KdikLE4NF5Vf2jhO1EQqPidm0e6s5Gn2EgL" +
			"yrn03nJzAgMBAAECggEAeOjPFaSnsJTwVczhGFT9ef2UvyZvFMvosTp6wYDzjN2J" +
			"KjoeondBhaTsnpWWHkbhZixPf0/Plw89RYX9YQ9IN7fmR5hCUTwwiDz1exWzAWWk" +
			"ImkqCEP5y8TKsb65XAvy5r5W4UrSISR2nq7Aq9MD9GzrGSL/tmnfPcGurShSmwy4" +
			"It3gzxNuw+PTd+oCP+w5n2CO7vDiZTzBompBqK8dVcM0TzX5upgImjQKgAhQpJKr" +
			"LlLbf3YVL9aU20AK9Q9QTxw7cDfmtShLQqYnOePmKNWIu/JS0YRnsRHLeA8DL5vF" +
			"QCotGXwH1vFeoR8/6j7ww61L2lZK4p8zyjKIlsWIgQKBgQDsh0Y55nqze4ertoUd" +
			"2mIPR7rnKKrjGLLouqGD5IRiUO8QDgVg95o4Y9ah7dKktZaacg+vbhIPwRjGDiUF" +
			"hBtfiy9R+c2YzxFGh+XGDfruibqEIpTd3tjBcAnooZipFnccQ+5CRGbDcuWFaDhM" +
			"m/GG7GTt/3vD0e9RTarF4f2izwKBgQDojEIJuEx3fgvZ45+nQgpOENBHzPNylr6p" +
			"TDAjgBXkXiahAc6c+vyYM2yJ6VSEz5NIU1QSw8kXk2VGrmROIOtQiO/k8YuVCxY/" +
			"/+nDn/NfcLyTFNj3W5jbVBZ9b32r2T/CrejdxIm8hD6q0DX88uRZIRDs8p+ckqWd" +
			"fnEe/ZEvHQKBgEiDgGgn3N5BtOpT3qO0W/PLTeWodhuBavgmn3XMDToHDgOiCMwd" +
			"nM5E7XxfaQDOGwnmhiCGYksqK+osU/VI9wtnpG5BY2LBuM4iw7Lgflm7J89yuqj6" +
			"tQE41BDZ2e+cz49+1ADE76xkATHRLdFuzbFLr/W3Kb5zEiee5AgerJ/JAoGADYMY" +
			"0zfCOa85QQ/Y1v8fWinf8EwYWTApI+0pXuayXvKZjAFu3/A1fSJ/zAOixZTKGgm9" +
			"eNmndZc660B205NWGPfb+JGQariaMl3MV3GT0pfaXTF46eaImzXnmKJByxp0eftg" +
			"7IHe/vUwLvyqJmh2nDcvpJT0cUSUGvKd4A8bwIECgYAUApzoPak6bB1bXEToXNg+" +
			"0yN39SIAjTidgeOyas02uNyCXanTjlzy5a4mRbV6+rjy+AgMNBBZW+9y8t5oSaDo" +
			"VgnwHztcmKvm3Yu7goANA51ymPOQuXyPfIku0XxGZxK9PRDc3KWUUWe5OeV9g2ec" +
			"hj8ObspkntH4GngVnnwG6w==";
	
	private static String alipay_public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjHJIeLWuUPhAXq8R2kwUgDVrPJZ8N2DDB7WoeirN20boz0XnueMWnl2dsAheB6szhAbrATcbZMIxG9m097cNOV250LWVdTZ8Jnr+AkiypJI/U3/nvDtA+4N145gp3SdkfvXWrlvVF05HNODZo5R3inNIV3YFc8HQuruf+NIUZGmzsgquSSBSjajY6ADhyVz0uI8ptizhBoxhzLaF22UcA+mAGfabehF4Ykn9kLJln3yOZimQn+cW9ox2pMM+o6cBIsL3Bge7eDbDuzpOMZEulxuKI6/U48dBBcO64iTd5l2ZgSBgiACvWwcFiLbN55lRzpfdt6OHY6+/wi+dayQCEQIDAQAB";

	private static String alipay_notify_url="http://115.47.154.137:8084/front/notify/alipay";
	
	private static String alipay_notify_url2="http://arz.ctq100.com/front/payback/alipay";
	private static String alipay_notify_url3="http://arz.ctq100.com/apiv1-1/notify/alipay";
	private static String alipay_return_url="http://115.47.154.137:8084/front/paysuccess";
	public static String getAlipay_return_url() {
		return alipay_return_url;
	}
	@Value("${ali.return_url}")
	public static void setAlipay_return_url(String alipay_return_url) {
		WebPropertyHolder.alipay_return_url = alipay_return_url;
	}
	public static String getAlipay_notify_url3() {
		return alipay_notify_url3;
	}
	@Value("${ali.notify_url3}")
	public  void setAlipay_notify_url3(String alipay_notify_url3) {
		WebPropertyHolder.alipay_notify_url3 = alipay_notify_url3;
	}

	private static Integer rollback;
	
	private static String acp_frontUrl="http://arz.ctq100.com/front/notify/acpbackUrl" ;
    
	private static String acp_backUrl ="http://arz.ctq100.com/front/notify/acpPay";
	
	private static String acp_mchid="802110048161266";
	
	
	public static String getAcp_frontUrl() {
		return acp_frontUrl;
	}
	@Value("${acpsdk.frontUrl}")
	public  void setAcp_frontUrl(String acp_frontUrl) {
		WebPropertyHolder.acp_frontUrl = acp_frontUrl;
	}
	
	public static String getAcp_backUrl() {
		return acp_backUrl;
	}
	@Value("${acpsdk.backUrl}")
	public void setAcp_backUrl(String acp_backUrl) {
		WebPropertyHolder.acp_backUrl = acp_backUrl;
	}

	public static String getAcp_mchid() {
		return acp_mchid;
	}
	@Value("${acpsdk.merid}")
	public  void setAcp_mchid(String acp_mchid) {
		WebPropertyHolder.acp_mchid = acp_mchid;
	}

	public static Integer getRollback() {
		return rollback;
	}

	@Value("${roll.back}")
	public void setRollback(Integer rollback) {
		WebPropertyHolder.rollback = rollback;
	}

	public static String getAlipay_notify_url() {
		return alipay_notify_url;
	}
	public static String getAlipay_notify_url2() {
		return alipay_notify_url2;
	}

	@Value("${ali.notify_url}")
	public void setAlipay_notify_url(String alipay_notify_url) {
		WebPropertyHolder.alipay_notify_url = alipay_notify_url;
	}

	@Value("${ali.notify_url2}")
	public void setAlipay_notify_url2(String alipay_notify_url2) {
		WebPropertyHolder.alipay_notify_url2 = alipay_notify_url2;
	}
	
	public static String getAlipay_public_key() {
		return alipay_public_key;
	}

	@Value("${ali.alipay_public_key}")
	public void setAlipay_public_key(String alipay_public_key) {
		WebPropertyHolder.alipay_public_key = alipay_public_key;
	}

	public static String getMerchant_private_key() {
		return merchant_private_key;
	}

	@Value("${ali.merchant_private_key}")
	public void setMerchant_private_key(String merchant_private_key) {
		WebPropertyHolder.merchant_private_key = merchant_private_key;
	}

	public static String getAliAppid() {
		return aliAppid;
	}

	@Value("${ali.appid}")
	public void setAliAppid(String aliAppid) {
		WebPropertyHolder.aliAppid = aliAppid;
	}

	public static String getWechatNotify() {
		return wechatNotify;
	}

	@Value("${wechat.notify.url}")
	public void setWechatNotify(String wechatNotify) {
		WebPropertyHolder.wechatNotify = wechatNotify;
	}
	@Value("${wechat.notify.url2}")
	public void setWechatNotify2(String wechatNotify2) {
		WebPropertyHolder.wechatNotify2 = wechatNotify2;
	}

	public static String getWechatAppid() {
		return wechatAppid;
	}

	@Value("${wechat.appid}")
	public void setWechatAppid(String wechatAppid) {
		WebPropertyHolder.wechatAppid = wechatAppid;
	}

	public static String getWechatkey() {
		return wechatkey;
	}

	@Value("${wechat.key}")
	public void setWechatkey(String wechatkey) {
		WebPropertyHolder.wechatkey = wechatkey;
	}

	public static String getWechatmchid() {
		return wechatmchid;
	}

	@Value("${wechat.mchid}")
	public void setWechatmchid(String wechatmchid) {
		WebPropertyHolder.wechatmchid = wechatmchid;
	}

	public static String getWechatNotify2() {
		return wechatNotify2;
	}
	
	public static String getWechatAppNotify() {
		return wechatAppNotify;
	}

	@Value("${wechat.notify.url}")
	public void setWechatAppNotify(String wechatAppNotify) {
		WebPropertyHolder.wechatAppNotify = wechatAppNotify;
	}
	@Value("${wechatApp.notify.url2}")
	public void setWechatAppNotify2(String wechatAppNotify2) {
		WebPropertyHolder.wechatAppNotify2 = wechatAppNotify2;
	}

	public static String getWechatAppAppid() {
		return wechatAppAppid;
	}

	//wx6edd5c1b6f7db8eb
	@Value("${wechatApp.appid}")
	public void setWechatAppAppid(String wechatAppAppid) {
		WebPropertyHolder.wechatAppAppid = wechatAppAppid;
	}

	public static String getWechatAppkey() {
		return wechatAppkey;
	}

	//194a05789d8e1a503374970178c6e7a0
	@Value("${wechatApp.key}")
	public void setWechatAppkey(String wechatAppkey) {
		WebPropertyHolder.wechatAppkey = wechatAppkey;
	}

	public static String getWechatAppmchid() {
		return wechatAppmchid;
	}

	//1509198611
	@Value("${wechatApp.mchid}")
	public void setWechatAppmchid(String wechatAppmchid) {
		WebPropertyHolder.wechatAppmchid = wechatAppmchid;
	}

	public static String getWechatAppNotify2() {
		return wechatAppNotify2;
	}
}