package com.kaysen.shop.threadpool;

import com.kaysen.shop.request.Request;
import com.kaysen.shop.request.RequestQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname RequestProcessorThreadPool
 * @Description 单例模式请求处理线程池
 * @Date 2019/8/9 17:24
 * @Created by ks.xu
 */
public class RequestProcessorThreadPool {
    //线程池
    private ExecutorService executorService= Executors.newFixedThreadPool(10);

    public RequestProcessorThreadPool(){
        RequestQueue requestQueue =RequestQueue.getInstance();
        for (int i = 0; i < 10; i++) {
            ArrayBlockingQueue<Request> arrayBlockingQueue = new ArrayBlockingQueue<Request>(100);
            requestQueue.addQueue(arrayBlockingQueue);
            executorService.submit(new RequestProcessorThread(arrayBlockingQueue));
        }
    }

    /**
     * 静态内部类单例模式
     */
    private static class Singleton{
        private static RequestProcessorThreadPool instance;
        static {
            System.out.println("初始化线程池实例。。。。。。。。。。。。。");
            instance=new RequestProcessorThreadPool();
        }
        public static RequestProcessorThreadPool getInstance(){
            return instance;
        }
    }
    public static RequestProcessorThreadPool getInstance(){
        return Singleton.getInstance();
    }

    /**
     * 初始化方法
     */
    public static void init(){
        getInstance();
    }
}
