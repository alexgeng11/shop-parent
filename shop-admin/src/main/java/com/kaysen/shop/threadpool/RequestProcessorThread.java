package com.kaysen.shop.threadpool;

import com.kaysen.shop.request.Request;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @Classname RequestProcessorThread
 * @Description TODO
 * @Date 2019/8/9 17:37
 * @Created by ks.xu
 */
public class RequestProcessorThread implements Callable<Boolean> {
    private ArrayBlockingQueue<Request> queue;

    public RequestProcessorThread(ArrayBlockingQueue<Request> queue) {
        this.queue = queue;
    }

    @Override
    public Boolean call() throws Exception {

        return null;
    }
}
