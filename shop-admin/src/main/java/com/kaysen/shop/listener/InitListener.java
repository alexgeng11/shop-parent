package com.kaysen.shop.listener;

import com.kaysen.shop.threadpool.RequestProcessorThreadPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Classname InitListener
 * @Description TODO
 * @Date 2019/8/9 17:18
 * @Created by ks.xu
 */
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("+++++++++++++++++++++++++++++++系统初始化+++++++++++++++++++++++++++++++");
        RequestProcessorThreadPool.init();


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
