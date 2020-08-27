package com.share.juc.sychronized.demo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName Juc_LockEscalation02
 * @Description 锁升级2-重量级锁
 * @Author fengxing
 * @Date 2020/8/27 16:08
 * @Version V1.0
 **/
public class Juc_LockEscalation02 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object a = new Object();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        //让线程晚点儿死亡，造成锁的竞争
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
