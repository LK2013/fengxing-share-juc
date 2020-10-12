package com.share.juc.aqs.demo;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReentrantLockDemo
 * @Description ReentrantLock 实例代码
 * @Author fengxing
 * @Date 2020/10/12 10:49
 * @Version V1.0
 **/
public class ReentrantLockDemo {


    public static void main(String[] args) throws InterruptedException {
        Computer computer=new Computer();
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for (int i=0;i<10;i++){
            new Thread(()->{
                computer.add(Thread.currentThread());
                countDownLatch.countDown();
            }).start();

        }
        countDownLatch.await();
        System.out.println("sum:"+computer.getSum());
    }

}
class Computer{
    private Lock lock=new ReentrantLock();
    private  int sum=0;
    public int add(Thread thread){
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for (int i=0;i<1000;i++){
               sum++;
            }

        }catch (Exception e){

        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();//必须释放
        }

        return sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
