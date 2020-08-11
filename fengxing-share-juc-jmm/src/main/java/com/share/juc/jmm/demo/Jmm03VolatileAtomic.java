package com.share.juc.jmm.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Jmm03VolatileAtomic
 * @Description AtomicInteger 保证原子性
 * @Author fengxing
 * @Date 2020/8/10 15:46
 * @Version V1.0
 **/
@Slf4j
public class Jmm03VolatileAtomic {

    private static AtomicInteger counter=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    counter.getAndIncrement();
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
