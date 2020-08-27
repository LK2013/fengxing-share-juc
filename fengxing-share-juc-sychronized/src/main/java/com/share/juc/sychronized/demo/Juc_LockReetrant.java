package com.share.juc.sychronized.demo;

/**
 * @ClassName Juc_LockReetrant
 * @Description 锁重入
 * @Author fengxing
 * @Date 2020/8/27 15:34
 * @Version V1.0
 **/
public class Juc_LockReetrant {
    private final static Object object = new Object();

    public static void reentrantlock(){
        String tname = Thread.currentThread().getName();
        synchronized (object) {
            System.out.println(String.format("{}:) hold {}->monitor lock",tname,object));
            synchronized (object){
                System.out.println(String.format("{}:) re-hold {}->monitor lock",tname,object));
            }
        }
    }

    public static void main(String[] args) {
        Juc_LockReetrant.reentrantlock();
    }

}
