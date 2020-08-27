package com.share.juc.sychronized.demo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description //非静态方法修饰-锁当前类的实例对象
 * @author fengxing
 * @param
 * @return
 * @Date
 * <pre>
 *
        com.share.juc.sychronized.demo.Juc_LockOnThisObject object internals:
        OFFSET  SIZE                TYPE DESCRIPTION                               VALUE
        0     4                     (object header)                           88 f2 45 03 (10001000 11110010 01000101 00000011) (54915720)
        4     4                     (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
        8     4                     (object header)                           05 c1 00 20 (00000101 11000001 00000000 00100000) (536920325)
        12     4   java.lang.Integer Juc_LockOnThisObject.stock                9
        Instance size: 16 bytes
        Space losses: 0 bytes internal + 0 bytes external = 0 bytes total

        markword 64位-前两行
        kclass指针地址 64位-压缩32位-第三行
        实例数据-最后一行

        大小端-小端-10001000
 * </pre>
 **/
public class Juc_LockOnThisObject {

    private Integer stock = 10;

    public synchronized void decrStock(){
        --stock;
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }

    public static void main(String[] args) {
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Juc_LockOnThisObject to = new Juc_LockOnThisObject();
        //System.out.println(ClassLayout.parseInstance(to).toPrintable());
        to.decrStock();

        Juc_LockOnThisObject to1 = new Juc_LockOnThisObject();
        to1.decrStock();
    }
}
