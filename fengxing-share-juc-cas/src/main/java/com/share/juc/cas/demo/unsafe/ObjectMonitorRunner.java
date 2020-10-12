package com.share.juc.cas.demo.unsafe;

import com.share.juc.cas.demo.utils.UnsafeInstance;
import sun.misc.Unsafe;

/**
 * 魔法类实现sychronized
 * @ClassName: ObjectMonitorRunner
 * @package com.share.juc.cas.demo.unsafe
 * @author: fengxing
 * @date: 2020/10/12 16:34
*/
public class ObjectMonitorRunner {
    static Object object = new Object();
    static Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
    public void method1(){
        unsafe.monitorEnter(object);
    }

    public void method2(){
        unsafe.monitorExit(object);
    }

    public static void main(String[] args) {
        //jvm内置锁
        synchronized (object){

            //写逻辑
        }
    }

}
