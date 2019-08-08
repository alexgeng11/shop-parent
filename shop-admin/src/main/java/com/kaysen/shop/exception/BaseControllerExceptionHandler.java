/*
 * Copyright (c) 2018, dreamkaylee@foxmail.com All Rights Reserved.
 */

package com.kaysen.shop.exception;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.AuthorizationException;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author limk
 * @date 2018年4月20日 下午3:37:13
 */
@RestControllerAdvice
public class BaseControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截验证异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    public void valid(AuthorizationException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestway =request.getHeader("x-requested-with");
        if(StringUtil.isNotEmpty(requestway)){//AJAX
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("login_status", "300");
            jsonObject.put("message", "invalidToken.");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonObject.toJSONString());
        }else{
            response.sendRedirect(request.getContextPath()+"/noAuth");
        }
    }


    
}
  