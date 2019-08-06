package com.kaysen.shop.pay.acp;



import com.lfm.pay.utils.WebPropertyHolder;

import java.util.HashMap;

/**
 * 银联支付配置
 * @author Niu Li
 * @date 2016/10/29
 */
public final class AcpPayConfig {

    //默认配置的是UTF-8
    public static String ENCODING_UTF8 = "UTF-8";

    //全渠道固定值
    public static String VERSION = "5.0.0";

    //前台通知地址
    public static String FRONTURL = WebPropertyHolder.getAcp_frontUrl();
    
    //后台通知地址
    public static String BACKURL = WebPropertyHolder.getAcp_backUrl();
    //消费通知地址
    public static String CONSUME_BACKURL = "http://localhost:8080/arz-web/front/notify/acpbackUrl";
    /**
     * 退款通知地址
     */
    public static String REFUND_BACKURL = "http://localhost:8080/arz-web/front/notify/acpbackUrl";
    /**
     * 签名方法 01 RSA
     */
    public static String SIGNMETHOD = "01";
    /**
     * 商户号
     */
    public static String MERID =WebPropertyHolder.getAcp_mchid();
    /**
     * 商户接入类型
     */
    public static String ACCESSTYPE = "0";
    /**
     * 账号类型
     */
    public static String ACCTYPE = "01";
    
    
    /**  
    * @Fields field:field:币种 
    */ 
    public static String CURRENCYCODE="156";
    /**
     *标记化支付信息域,测试使用
     */
    public static String TOKENPAYDATA = "{trId=62000000016&tokenType=01}";

    /**
     * 成功标识
     */
    public static String SUCCESS = "00";

    /**
     * 不可实例化
     */
    private AcpPayConfig(){}

    private volatile static AcpPayClient AcpPayClient = null;

    /**
     * 双重检验单例
     * @return 银联pay客户端
     */
    public static AcpPayClient getInstance(){
        if (AcpPayClient == null){
            synchronized (AcpPayConfig.class){
                if (AcpPayClient == null){
                    HashMap<String,String> initMap = new HashMap<>();
                    initMap.put("version", VERSION);                   //版本号
                    initMap.put("encoding", ENCODING_UTF8);            //字符集编码 可以使用UTF-8,GBK两种方式
                    initMap.put("signMethod", SIGNMETHOD);                           //签名方法 目前只支持01-RSA方式证书加密
                    initMap.put("bizType", "000201");
                    initMap.put("channelType", "07");
                    initMap.put("merId", MERID);                   			   //商户号码（本商户号码仅做为测试调通交易使用，该商户号配置了需要对敏感信息加密）测试时请改成自己申请的商户号，【自己注册的测试777开头的商户号不支持代收产品】
                    initMap.put("accessType", "0");					//接入类型，0：直连商户
                    initMap.put("currencyCode", "156");
                    return new AcpPayClient(initMap);
                }
            }
        }
        return AcpPayClient;
    }

}
