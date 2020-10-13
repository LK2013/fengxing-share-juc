package com.share.juc.concurrentutil.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @author fengxing
 * <pre>
 * 允许一个或多个线程等待其他线程完成操作。
 * 当我们调用CountDownLatch的countDown方法时，N就会减1，CountDownLatch的await方法会阻塞当前线程，直到N变成零。
 * 由于countDown方法可以用在任何地方，所以这里说的N个点，可以是N个线程，也可以是1个线程里的N个执行步骤。
 * 用在多个线程时，只需要把这个CountDownLatch的引用传递到线程里即可。
 * </pre>
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        //模拟多线程解析excel不同sheet数据
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+":sheet1已解析完");
                countDownLatch.countDown();
            } catch (Exception e) {

            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+":sheet2已解析完");
                countDownLatch.countDown();
            } catch (Exception e) {

            }
        }).start();
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+":excel全部解析完");
    }
}

