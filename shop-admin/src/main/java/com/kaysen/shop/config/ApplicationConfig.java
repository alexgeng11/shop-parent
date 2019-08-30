package com.kaysen.shop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname ApplicationConfig
 * @Description TODO
 * @Date 2019/8/29 11:42
 * @Created by ks.xu
 */
@Configuration
public class ApplicationConfig {
    /**
     * Bean Util
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
