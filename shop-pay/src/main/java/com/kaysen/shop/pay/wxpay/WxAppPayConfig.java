/**  
* @Title: WxpayConfig.java  
* @Package com.lfm.com.lfm.pay.wxpay
* @Description: TODO  
* @author lujun  
* @date 2018年5月15日  
* @version V1.0  
*/ 
package com.kaysen.shop.pay.wxpay;

import com.github.wxpay.sdk.WXPayConfig;
import com.lfm.pay.utils.WebPropertyHolder;

import java.io.InputStream;

/**  
* @ClassName: WxpayConfig  
* @Description: 微信配置 
* @author lujun  
* @date 2018年5月15日    
*/
public class WxAppPayConfig implements WXPayConfig{

	private static WxAppPayConfig INSTANCE;
	
	public static WxAppPayConfig getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WxAppPayConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WxAppPayConfig();
                }
            }
        }
        return INSTANCE;
    }
	
	
	@Override
	public String getAppID() {
		return WebPropertyHolder.getWechatAppAppid();
	}

	
	@Override
	public String getKey() {
		return WebPropertyHolder.getWechatAppkey();
	}

	@Override
	public String getMchID() {
		return "1509198611";
	}
	
	@Override
	public InputStream getCertStream() {
		return null;
	}

	@Override
	public int getHttpConnectTimeoutMs() {
		return 0;
	}

	@Override
	public int getHttpReadTimeoutMs() {
		return 0;
	}


}
