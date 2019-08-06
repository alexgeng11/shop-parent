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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**  
* @ClassName: WxpayConfig  
* @Description: 微信配置 
* @author lujun  
* @date 2018年5月15日    
*/
public class WxpayConfig implements WXPayConfig{
	private byte[] certData;
	private static WxpayConfig INSTANCE;
	
	public static WxpayConfig getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WxpayConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WxpayConfig();
                }
            }
        }
        return INSTANCE;
    }
	public static WxpayConfig getInstance(String certPath) throws Exception{
        if (INSTANCE == null) {
            synchronized (WxpayConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WxpayConfig(certPath);
                }
            }
        }
        return INSTANCE;
    }
    public WxpayConfig(String certPath)  throws Exception{
//		String certPath = "/path/to/apiclient_cert.p12";
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}
    public WxpayConfig()  throws Exception{
	}

	
	@Override
	public String getAppID() {
		return WebPropertyHolder.getWechatAppid();
	}

	
	@Override
	public String getKey() {
		return WebPropertyHolder.getWechatkey();
	}

	@Override
	public String getMchID() {
		return WebPropertyHolder.getWechatmchid();
	}
	
	@Override
	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	@Override
	public int getHttpConnectTimeoutMs() {
		return 8000;
	}

	@Override
	public int getHttpReadTimeoutMs() {
		return 10000;
	}


}
