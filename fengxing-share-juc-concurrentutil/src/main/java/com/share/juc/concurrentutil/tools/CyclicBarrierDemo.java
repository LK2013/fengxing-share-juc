package com.share.juc.concurrentutil.tools;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description
 * @author fengxing
 * @Date
 * <pre>
 *  让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，
 *  屏障才会开门，所有被屏障拦截的线程才会继续运行
 * </pre>
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"已准备好");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"冲刺");
            } catch (Exception e) {

            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"已准备好");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"冲刺");
            } catch (Exception e) {

            }
        }).start();

        cyclicBarrier.await();//主线程
    }
}
