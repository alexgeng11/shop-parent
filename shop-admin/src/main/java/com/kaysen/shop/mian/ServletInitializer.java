package com.kaysen.shop.mian;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//由于我们采用web3.0 规范，是没有web.xml 的，而此类的作用与web.xml相同。
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationRun.class);
    }
}