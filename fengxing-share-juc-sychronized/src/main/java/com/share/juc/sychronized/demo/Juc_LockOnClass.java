package com.share.juc.sychronized.demo;

/**
 * @Description //修饰静态方法-锁类对象
 * @author fengxing
 * @param []
 * @return
 * @Date
 * <pre>
 * 业务逻辑描述：
 * </pre>
 **/
public class Juc_LockOnClass {
    static int stock;

    public static synchronized void decrStock(){
        System.out.println(--stock);
    }

    public static synchronized void cgg(){
        System.out.println();
    }

    public static void main(String[] args) {
        //Juc_LockOnClass.class对象
        Juc_LockOnClass.decrStock();
    }

}
