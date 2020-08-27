package com.share.juc.sychronized.demo;

/**
 * @Description //锁消除-线程逃逸分析和标量替换会进行优化
 * @author fengxing
 * @param []
 * @return
 * @Date
 * <pre>
 * 业务逻辑描述：
 * </pre>
 **/
/**
 *  -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*Juc_LockAppend.method
 **/
public class Juc_LockAppend {

    StringBuffer stb = new StringBuffer();
    Object object=new Object();

    private synchronized void method(){
        synchronized (object){
        stb.append("杨过");
        stb.append("小龙女");
        stb.append("大雕");
        stb.append("郭靖");
        }
    }

    public static void main(String[] args) {
        Juc_LockAppend juc_lockAppend=new Juc_LockAppend();
       juc_lockAppend.method();

    }
}
