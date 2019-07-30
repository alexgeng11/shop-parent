package com.kaysen.shop.mian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Classname ApplicationRun
 * @Description TODO
 * @Date 2019/7/29 15:46
 * @Created by ks.xu
 */
@SpringBootApplication
//@EnableWebMvc
@ComponentScan(basePackages = "com.kaysen.shop.*")
public class ApplicationRun {
    public static void main(String args[]){
        SpringApplication.run(ApplicationRun.class,args);
    }
}
