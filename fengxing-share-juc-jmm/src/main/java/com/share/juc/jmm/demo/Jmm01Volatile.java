package com.share.juc.jmm.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Jmm01Volatile
 * @Description volatile，验证可见性
 * @Author fengxing
 * @Date 2020/8/10 11:38
 * @Version V1.0
 **/
/**
 * volatile保证即时可见性。
 *
 * -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*Jmm01Volatile.refresh -Djava.compiler=NONE
 * javap -v -verbose C:\fengxingshare\fengxing-share-juc\fengxing-share-juc-jmm\target\classes\com\share\juc\jmm\demo\Jmm01Volatile.class
 * */
@Slf4j
public class Jmm01Volatile {
    private static volatile boolean initFlag = false;


    public static void refresh(){
        log.info("refresh data.......");
        initFlag = true;
        log.info("refresh data success.......");
    }

    public static void main(String[] args){
        Thread threadA = new Thread(()->{
            while (!initFlag){
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
