package com.share.juc.threadpool.schedule;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池
 * @ClassName: ScheduleThreadPoolRunner
 * @package com.share.juc.threadpool.schedule
 * @author: lk
 * @date: 2020/10/13 14:21
*/
@Slf4j
public class ScheduleThreadPoolRunner {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("我要延迟3s执行");
            return 1;
        }, 5000, TimeUnit.MILLISECONDS);

        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("我要延迟3s执行");
            return 1;
        }, 10000, TimeUnit.MILLISECONDS);

        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("我要延迟3s执行");
            return 1;
        }, 3000, TimeUnit.MILLISECONDS);

        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("我要延迟3s执行");
            return 1;
        }, 1000, TimeUnit.MILLISECONDS);
        //提交任务的线程-接着干活
        //xxxxx
        //xxxx
        //xxxx
        /*try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/


        //发心跳，service1->service2,每次过5s，发送一个心跳，证明s2可用
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            log.info("send heart beat");
            long starttime = System.currentTimeMillis(), nowtime = starttime;
            while ((nowtime - starttime) < 5000) {
                nowtime = System.currentTimeMillis();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("task over....");
            throw new RuntimeException("unexpected error , stop working");
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            log.info("send heart beat");
            long starttime = System.currentTimeMillis(), nowtime = starttime;
            while ((nowtime - starttime) < 5000) {
                nowtime = System.currentTimeMillis();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("task over....");
            throw new RuntimeException("unexpected error , stop working");
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        //定时类
        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.info("send heart beat");
                throw new RuntimeException("unexpected error , stop working");
            }
        },1000,2000);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.info("send heart beat");
                throw new RuntimeException("unexpected error , stop working");
            }
        },1000,2000);*/

        /*scheduledThreadPoolExecutor.scheduleAtFixedRate(()->{
            log.info("running...");
        },1000,2000,TimeUnit.MILLISECONDS);*/

    }
}
