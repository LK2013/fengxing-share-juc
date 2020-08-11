package com.share.juc.jmm.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Jmm04SingleInstance
 * @Description doublecheck单例模式
 * @Author fengxing
 * @Date 2020/8/10 16:10
 * @Version V1.0
 **/
@Slf4j
public class Jmm04SingleInstance {

    /**
     * 查看汇编指令
     * -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*Jmm04SingleInstance.getInstance
     */
    private volatile static Jmm04SingleInstance myinstance;

    private Jmm04SingleInstance(){}

    /**
     * 双重锁机制保证单例安全
     * @return
     */
    public static Jmm04SingleInstance getInstance() {
        if (myinstance == null) {
            synchronized (Jmm04SingleInstance.class) {
                if (myinstance == null) {
                    //多线程下，23可能会进行指令重排。需要用volatile禁止指令重排
                    //1 memory = allocate();//1.分配对象内存空间
                    //2 instance(memory);//2.初始化对象
                    //3 instance = memory;//3.设置instance指向刚分配的内存地址，此时instance！=null
                    myinstance = new Jmm04SingleInstance();
                }
            }
        }
        return myinstance;
    }

    public static void main(String[] args) {
        Jmm04SingleInstance.getInstance();
    }
}
