package com.share.juc.aqs.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionDemo
 * @Description 业务，两个线程交替打印星星
 * @Author fengxing
 * @Date 2020/10/12 11:20
 * @Version V1.0
 **/
public class ConditionDemo {
    public static void main(String[] args) {
        MyService service=new MyService();
        for(int i=0;i<10;i++){
            new Thread(()->service.set()).start();
            new Thread(()->service.get()).start();
        }
    }

}
class MyService {
    private ReentrantLock lock=new ReentrantLock(false);
    private Condition condition=lock.newCondition();
    private volatile boolean hasValue=false;
    public void set(){
        try {
            lock.lock();
            while (hasValue==true){
                System.out.println(Thread.currentThread().getName()+":有可能★ ★连续");
                condition.await();// 挂起，等待唤醒
            }
            System.out.println(Thread.currentThread().getName()+":打印★");
            hasValue=true;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while (hasValue==false){
                System.out.println(Thread.currentThread().getName()+":有可能☆ ☆连续");
                condition.await();//挂起，等待唤醒
            }
            System.out.println(Thread.currentThread().getName()+":打印☆");
            hasValue=false;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}