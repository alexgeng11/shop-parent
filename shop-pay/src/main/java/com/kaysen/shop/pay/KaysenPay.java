package com.kaysen.shop.pay;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.kaysen.shop.pay.acp.AcpPayTrade;
import com.kaysen.shop.pay.alipay.AliPayUtil;
import com.kaysen.shop.pay.alipay.AlipayConfig;
import com.kaysen.shop.pay.wxpay.WxpayUtil;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Pay-Demo
 * @ClassName KaysenPay
 * @description: TODO
 * @author: xks
 * @create: 2018-11-07 10:52
 **/
public class KaysenPay {
     public static void main(String args[]) throws Exception {

         //支付宝扫码支付
         Map<String, Object> params=new HashMap<String,Object>();
         //订单号
         params.put("out_trade_no", "10000011");
         //金额(元)
         params.put("total_amount",0.01);
         //商品名称
         params.put("subject", "爱睿智");
         String aliurl = AliPayUtil.aliPayPrecreate(params);
         System.out.println("支付宝扫码字符串为："+aliurl);

        //微信扫码支付
         String ipaddr=InetAddress.getLocalHost().getHostAddress();
         //订单号
         params.put("out_trade_no", "10000011");
         //金额(分)
         params.put("total_fee",1);
         //IP
         params.put("spbill_create_ip", ipaddr);
         //商品id
         params.put("product_id", "10000011");
         //商品名
         params.put("body", "爱睿智");
         String wechaturl = WxpayUtil.wxPayPrecreate(params);
         System.out.println("微信扫码字符串为："+wechaturl);

//        银联网关支付
         Map<String, String> paramMap=new HashMap<String,String>();
         //订单号
         paramMap.put("orderId", "10000011");
         //金额（分）
         paramMap.put("txnAmt","1");
         //返回的html代码
         String html = AcpPayTrade.gateWayPay(paramMap);
         System.out.println(html);


//        支付宝网关支付
         AlipayClient alipayClient= new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
         AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
         alipayRequest.setReturnUrl(AlipayConfig.notify_url);
         alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
         //商户订单号，商户网站订单系统中唯一订单号，必填
         String out_trade_no = new String("10000011");
         //付款金额，必填
         String total_amount = new String("0.01".getBytes("ISO-8859-1"),"UTF-8");
         //订单名称，必填
         String subject =new String("爱乐淘");
         //商品描述，可空
         String body = new String("乐器".getBytes("UTF-8"),"UTF-8");

         alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                 + "\"total_amount\":\""+ total_amount +"\","
                 + "\"subject\":\""+ subject +"\","
                 + "\"body\":\""+ body +"\","
                 + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
         String result = alipayClient.pageExecute(alipayRequest).getBody();
         System.out.print(result);
      }
}
