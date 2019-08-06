package com.kaysen.shop.pay.acp;


import com.kaysen.shop.pay.acp.sdk.AcpService;
import com.kaysen.shop.pay.utils.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 银联交易入口,只为了和支付宝,微信调用统一
 * @author Niu Li
 * @date 2016/10/31
 */
public class AcpPayTrade {

    private static Logger logger = LoggerFactory.getLogger(AcpPayTrade.class);
    
    
    
    /**  
    * @Title: gateWayPay  
    * @Description: 网关支付
    * @param @param paramMap
    * @param @param customerInfo
    * @param @return
    * @return String 
    * @throws  
    */ 
    public static String gateWayPay(Map<String, String> paramMap){
        return AcpPayConfig.getInstance().gatewayPay(paramMap);
    }
    
    public static String gateAppWayPay(Map<String, String> paramMap){
        return AcpPayConfig.getInstance().gateAppWayPay(paramMap);
    }

    /**
     * 开通token支付
     * @param paramMap 请求参数
     * @return 请求返回结果
     */
    public String tokenOpen(Map<String, String> paramMap,Map<String, String> customerInfo){
        return AcpPayConfig.getInstance().tokenOpen(paramMap,customerInfo);
    }

    /**
     * 发送短信
     * @param paramMap 请求参数
     * @return 返回结果
     */
    public Map<String,String> msg(Map<String, String> paramMap,Map<String, String> customerInfo){
        return AcpPayConfig.getInstance().msgSend(paramMap,customerInfo);
    }

    /**
     * 消费
     * @param paramMap 请求参数
     * @return 请求结果
     */
    public Map<String,String> consume(Map<String, String> paramMap,Map<String, String> customerInfo){
        return  AcpPayConfig.getInstance().consume(paramMap,customerInfo);
    }

    /**
     * 退款
     * @param paramMap 请求参数
     * @return 请求结果
     */
    public static Map<String,String> refund(Map<String, String> paramMap){
        return  AcpPayConfig.getInstance().refund(paramMap);
    }

    /**
     * 银行卡回调验签
     * @param request  回调请求
     * @return true成功
     */
    public static boolean verifyNotify(HttpServletRequest request){
        Map<String,String> paranMap = SignUtil.request2Map(request);
        logger.debug("银行卡回调参数:"+paranMap.toString());
        boolean ischeck = AcpService.validate(paranMap, AcpPayConfig.ENCODING_UTF8);
        logger.debug("银行卡回调验签结果:"+ischeck);
        return ischeck;
    }
}
