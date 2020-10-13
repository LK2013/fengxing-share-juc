package com.share.juc.threadpool.futureandcallable;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future和Callable测试
 * @ClassName: FutureAndCallableDemo
 * @package com.share.juc.threadpool.futureandcallable
 * @author: fengxing
 * @date: 2020/10/13 14:33
*/
public class FutureAndCallableDemo {
    public static void main(String[] args)throws Exception {
        long starttime=System.currentTimeMillis();
        HashMap<String,Object> hashMap=new HashMap<>();
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        /*FutureTask<String> osTask = new FutureTask<String>(()->{
            Thread.sleep(1000);
            return System.getProperty("os.name");//操作系统名称
        });


        FutureTask<String> userTask = new FutureTask<String>(()->{
            Thread.sleep(2000);
            return System.getProperty("user.name");//用户的账户名称
        });


        FutureTask<String> vmTask = new FutureTask<String>(()->{
            Thread.sleep(3000);
            return System.getProperty("java.vm.name");//java虚拟机实现名称
        });

        FutureTask<String> compilerTask = new FutureTask<String>(()->{
            Thread.sleep(4000);
            return System.getProperty("java.version");//java JIT 编译器的名称
        });*/

        Future future1= executorService.submit(()->{
            Thread.sleep(1000);
            return System.getProperty("os.name");//操作系统名称
        });
        Future future2= executorService.submit(()->{
            Thread.sleep(2000);
            return System.getProperty("user.name");//用户的账户名称
        });
        Future future3= executorService.submit(()->{
            Thread.sleep(3000);
            return System.getProperty("java.vm.name");//java虚拟机实现名称
        });
        Future future4= executorService.submit(()->{
            Thread.sleep(4000);
            return System.getProperty("java.version");//java JIT 编译器的名称
        });


        String osname=future1.get().toString();
        String username=future2.get().toString();
        String vmname=future3.get().toString();
        String javaversion=future4.get().toString();
        hashMap.put("osname",osname);
        hashMap.put("username",username);
        hashMap.put("vmname",vmname);
        hashMap.put("javaversion",javaversion);
        System.out.println(hashMap.toString());
        System.out.println("threadpool join用时:"+ (System.currentTimeMillis()-starttime));
    }

}
