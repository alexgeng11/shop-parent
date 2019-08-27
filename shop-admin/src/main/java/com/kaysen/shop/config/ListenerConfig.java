package com.kaysen.shop.config;

import com.kaysen.shop.listener.InitListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname ApplicationConfig
 * @Description 监听器配置
 * @Date 2019/8/9 17:19
 * @Created by ks.xu
 */
//@Configuration
public class ListenerConfig {
    /**
     * 系统初始化监听配置
     * @return
     */
//    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean=
                new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new InitListener());
        return servletListenerRegistrationBean;
    }
}
