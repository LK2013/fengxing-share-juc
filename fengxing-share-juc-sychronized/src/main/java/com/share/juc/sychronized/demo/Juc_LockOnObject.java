package com.share.juc.sychronized.demo;

/**
 * @Description //修改对象代码块-锁对象
 * @author fengxing
 * @param []
 * @return
 * @Date
 * <pre>
 * 业务逻辑描述：
 * </pre>
 **/
public class Juc_LockOnObject {

    public static Object object = new Object();

    private Integer stock = 10;

    public void decrStock(){
        //T1,T2
        synchronized (object){
            --stock;
            if(stock <= 0){
                System.out.println("库存售罄");
                return;
            }
        }
    }
}
