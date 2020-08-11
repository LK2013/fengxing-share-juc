package com.share.juc.jmm.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Jmm03VolatileNoAtomic
 * @Description volatile 不保证原子性
 * @Author fengxing
 * @Date 2020/8/10 15:28
 * @Version V1.0
 **/
@Slf4j
public class Jmm03VolatileNoAtomic {
    private volatile static int counter = 0;
    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                        counter++;//分三步- 读，自加，写回
                        //读
                }
                try {
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } );
            thread.start();
        }

        countDownLatch.await();

        log.info("counter:{}",counter);

    }
}
