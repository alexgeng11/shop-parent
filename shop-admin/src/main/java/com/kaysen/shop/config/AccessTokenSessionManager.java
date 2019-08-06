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
    public static final String ACCESS_TOKEN = "Access-Token";
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String sessionId = httpServletRequest.getHeader(ACCESS_TOKEN);
            if (sessionId != null) {
                try {
                    Session session = retrieveSessionFromDataSource(sessionId);
                    System.out.println("Access-Token:" + session.getId());
                    return sessionId;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.getSessionId(request, response);
    }
}
