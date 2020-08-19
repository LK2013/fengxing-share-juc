package com.share.juc.jmm.demo;

import com.share.juc.jmm.util.UnsafeInstance;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Jmm02VolatileOrder
 * @Description 有volatile ，有序性验证
 * @Author fengxing
 * @Date 2020/8/10 14:29
 * @Version V1.0
 **/
@Slf4j
public class Jmm02VolatileOrder {

        private  static volatile int x = 0, y = 0;
        private  static volatile int a = 0, b = 0;

        public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;){
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread t1 = new Thread(()->{
                //shortWait(10000);
                a = 1;//
                x = b;//
            });

            Thread t2 = new Thread(()->{
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                log.info(result);
            }
        }

    }

        /**
         * 等待一段时间，时间单位纳秒
         * @param interval
         */
        public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}
