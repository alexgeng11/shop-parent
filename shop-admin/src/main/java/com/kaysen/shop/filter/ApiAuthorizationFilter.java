package com.kaysen.shop.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ExtendRolesAuthorizationFilter
 * @Description TODO
 * @Date 2019/8/4 20:56
 * @Created by ks.xu
 */
public class ApiAuthorizationFilter extends AccessControlFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();
    private SecurityManager securityManager;


    public SecurityManager getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        if(isLoginRequest(servletRequest, servletResponse)
                ||pathMatcher.match("/api/login",request.getRequestURI())
                ||pathMatcher.match("/api/noAuth",request.getRequestURI())
        ){// && isEnabled()
            return Boolean.TRUE;
        }
        Subject subject = getSubject(servletRequest, servletResponse);
        if (subject.isAuthenticated()){
            try {
                subject.checkPermission("index");
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login_status", "300");
        jsonObject.put("message", "invalidToken.");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write(jsonObject.toJSONString());
        return Boolean.FALSE ;
    }
}
