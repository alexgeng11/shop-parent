package com.kaysen.shop.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Classname RequestQueue
 * @Description TODO
 * @Date 2019/8/12 10:06
 * @Created by ks.xu
 */
public class RequestQueue {
    //内存队列
    private List<ArrayBlockingQueue> queues=new ArrayList<ArrayBlockingQueue>();
    /**
     * 静态内部类单例模式
     */
    private static class Singleton{
        private static RequestQueue instance;
        static {
            System.out.println("初始化线程池实例。。。。。。。。。。。。。");
            instance=new RequestQueue();
        }
        public static RequestQueue getInstance(){
            return instance;
        }
    }
    public static RequestQueue getInstance(){
        return Singleton.getInstance();
    }

    /**
     * 添加到队列
     * @param queue
     */
    public void addQueue(ArrayBlockingQueue<Request> queue){
        this.queues.add(queue);
    }
}
