package com.share.juc.cas.demo.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger自增测试类
 * @ClassName: T1_AtomicInteger
 * @package com.share.juc.cas.demo.atomic
 * @author: fengxing
 * @date: 2020/10/12 17:04
*/
public class T1_AtomicInteger {

    public static int total = 0;
    static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    /*synchronized () {
                        total++;//cas
                    }*/
                    atomic.getAndIncrement();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println(atomic.get());
    }
}
