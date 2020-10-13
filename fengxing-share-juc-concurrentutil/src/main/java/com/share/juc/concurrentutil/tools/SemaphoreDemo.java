package com.share.juc.concurrentutil.tools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @author fengxing
 * @Date   2020年10月13日11:13:45
 * <pre>
 * Semaphore是一个计数信号量。
    从概念上将，Semaphore包含一组许可证。
    如果有需要的话，每个acquire()方法都会阻塞，直到获取一个可用的许可证。
    每个release()方法都会释放持有许可证的线程，并且归还Semaphore一个可用的许可证。
    然而，实际上并没有真实的许可证对象供线程使用，Semaphore只是对可用的数量进行管理维护。
 * </pre>
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i=0;i<10;i++){
            new Thread(new Task(semaphore,"李磊+"+i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore,String tname){
            super(tname);
            this.semaphore = semaphore;
            //this.setName(tname);
        }
        @Override
        public void run() {
            try {
                //semaphore.acquireUninterruptibly();
                /*semaphore.acquire();//获取公共资源

                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                Thread.sleep(5000);

                semaphore.release();//释放公共资源*/

                if(semaphore.tryAcquire(500, TimeUnit.MILLISECONDS)){
                    System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                    Thread.sleep(5000);
                    semaphore.release();//释放公共资源
                }else{
                    fallback();//限流，降级
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void fallback(){
            System.out.println("降级");
        }
    }
}
