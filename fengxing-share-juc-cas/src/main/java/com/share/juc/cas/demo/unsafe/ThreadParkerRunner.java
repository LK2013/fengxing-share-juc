package com.share.juc.cas.demo.unsafe;

import com.share.juc.cas.demo.utils.UnsafeInstance;
import sun.misc.Unsafe;

/**
 * 利用魔法类实现线程的阻塞和唤醒
 * @ClassName: ThreadParkerRunner
 * @package com.share.juc.cas.demo.unsafe
 * @author: fengxing
 * @date: 2020/10/12 16:32
*/
public class ThreadParkerRunner {

    static Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread - is running----");
                //true则会实现ms定时,false则会实现ns定时。
                unsafe.park(false,0L); //阻塞当前线程
                System.out.println("thread is over-----");
            }
        });

        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("唤醒Thread-t");
        unsafe.unpark(t);

    }

}
