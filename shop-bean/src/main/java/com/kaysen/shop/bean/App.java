package com.kaysen.shop.bean;

import com.google.gson.Gson;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname App
 * @Description TODO
 * @Date 2019/7/23 15:41
 * @Created by ks.xu
 */
public class App {
    public static String httpPostWithjson(String url, String json) throws IOException {
        // 设置默认工厂类
        System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
// 设置日志打印类
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
//设置默认日志级别
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.simplelog.defaultlog", "error");
        String result = "";
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            BasicResponseHandler handler = new BasicResponseHandler();
            StringEntity entity = new StringEntity(json, "utf-8");//解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            result = httpClient.execute(httpPost, handler);
            return result;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    public static String unicodeToString(String unicode) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicode);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            unicode = unicode.replace(matcher.group(1), ch + "");
        }
        return unicode;
    }
    public static void main(String args[]){
        String httpURL = "https://webapi.leigod.com/api/user/card/cdkey";
        try {

            while (true){
                StringBuffer stringBuffer=new StringBuffer();
                Map<String,String> paramsMap=new HashMap<>();
                paramsMap.put("account_token","Q4fUyAUwfAAzn5dfaj3Dgsfn69mCZ0DorLv3NdHxQUwsGFZbQKSAxf1cvkqBB3uP");
                stringBuffer
                        .append(getRandomString(4)).append("-")
                        .append(getRandomString(4)).append("-")
                        .append(getRandomString(4)).append("-").append(getRandomString(4));
                System.out.println("CD Key："+stringBuffer.toString());
                paramsMap.put("cd_key",stringBuffer.toString());
                paramsMap.put("lang","zh_CN");
                String result1 = httpPostWithjson(httpURL, new Gson().toJson(paramsMap));

                if (result1.contains("400006")){
                    break;
                }
                System.out.println(unicodeToString(result1));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
