package com.kaysen.shop.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @Classname AccessTokenSessionManager
 * @Description TODO
 * @Date 2019/8/4 21:18
 * @Created by ks.xu
 */
public class AccessTokenSessionManager extends DefaultWebSessionManager {
    //指定token名称
    public static final String ACCESS_TOKEN = "Access-Token";
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            //从header取得token（sessionID，登录时将sessionid返回给前端）
            String sessionId = httpServletRequest.getHeader(ACCESS_TOKEN);
            if (sessionId != null) {
                try {
                    //取回session，作用是判断前端传得sessionid有没有效，没有就会抛出异常，然后走正常流程取sessionid
                    Session session = retrieveSessionFromDataSource(sessionId);
                    System.out.println("Access-Token:" + session.getId());
                    //返回前端传的sessionid
                    return sessionId;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //正常取sessionid
        return super.getSessionId(request, response);
    }
}
