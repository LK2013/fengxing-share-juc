package com.share.juc.threadpool.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolCustomDemo
 * @Description 自定义线程池
 * @Author fengxing
 * @Date 2020/10/13 14:03
 * @Version V1.0
 **/
public class ThreadPoolCustomDemo {
    public static void main(String[] args) {
        //自带的4个线程池
        //Executors.newSingleThreadExecutor();
        //Executors.newScheduledThreadPool();
        //Executors.newFixedThreadPool(2);
        //Executors.newCachedThreadPool();



        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("i m task ：" + Thread.currentThread().getName());
                }
            }, i);
        }

        threadPoolExecutor.shutdown();  //running->shutdown
        threadPoolExecutor.shutdownNow(); //running->stop
    }
}
