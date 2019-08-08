package com.kaysen.shop.config;

import com.kaysen.shop.filter.ParamsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname FiltersConfig
 * @Description 过滤器相关配置
 * @Date 2019/8/4 20:41
 * @Created by ks.xu
 */
@Configuration
public class FiltersConfig {
    /**
     * 过滤器
     * @return
     */
    ParamsFilter paramsFilter(){
        return new ParamsFilter();
    }

    /**
     * 过滤器注册
     * @return
     */
    @Bean
    public FilterRegistrationBean ParamsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(paramsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("accessEnforcer");
        registration.setOrder(1);
        return registration;
    }






}
