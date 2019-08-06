package com.kaysen.shop.config;

import com.kaysen.shop.filter.ParamsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname FiltersConfig
 * @Description TODO
 * @Date 2019/8/4 20:41
 * @Created by ks.xu
 */
@Configuration
public class FiltersConfig {
//    @Bean
//    public FilterRegistrationBean ParamsFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(getParamsFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("accessEnforcer");
//        registration.setOrder(1);
//        return registration;
//    }


//    @Bean
//    ParamsFilter getParamsFilter(){
//        return new ParamsFilter();
//    }


}
