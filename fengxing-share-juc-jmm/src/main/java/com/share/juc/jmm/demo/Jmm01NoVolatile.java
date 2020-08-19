package com.share.juc.jmm.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Jmm01NoVolatile
 * @Description 不加volatile，验证可见性
 * @Author fengxing
 * @Date 2020/8/10 11:38
 * @Version V1.0
 **/
/**
 * 上下文切换会对性能造成负面影响。然而，一些上下文切换相对其他切换而言更加昂贵；
 * 其中一个更昂贵的上下文切换是跨核上下文切换（Cross-Core Context Switch）。
 * 一个线程可以运行在一个专用处理器上，也可以跨处理器。由单个处理器服务的线程都有处理器关联（Processor Affinity），这样会更加有效。
 * 在另一个处理器内核抢占和调度线程会引起缓存丢失，作为缓存丢失和过度上下文切换的结果要访问本地内存。总之，这称为“跨核上下文切换”。
 **/

@Slf4j
public class Jmm01NoVolatile {

    private  static  boolean initFlag = false;

    public static void refresh(){
        log.info("refresh data.......");
        initFlag = true;
        log.info("refresh data success.......");
    }
    public  static int caculate(){
        int a=0;
        int b=1;
        return a+b;
    }

    public static void main(String[] args){
        log.info("start");
        Thread threadA = new Thread(()->{
            while (!initFlag){
                //log.info("I am runing");// 切换上下文
                //int caculateResult = caculate();
                //log.info("计算结果:{}",caculateResult);
               /* try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

            }
            log.info("线程：" + Thread.currentThread().getName()
                    + "当前线程嗅探到initFlag的状态的改变");
        },"threadA");
        threadA.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadB = new Thread(()->{
            refresh();
        },"threadB");
        threadB.start();
    }

}
