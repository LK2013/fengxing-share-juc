package com.share.juc.threadpool.futureandcallable;

import java.util.concurrent.*;

/**
 * CallableDemo
 * @ClassName: CallableDemo
 * @package com.share.juc.threadpool.futureandcallable
 * @author: fengxing
 * @date: 2020/10/13 14:41
*/
public class CallableDemo {


    public static void main(String[] args)throws Exception {
        //1.创建callable 任务
        MyComputeTask myComputeTask=new MyComputeTask();
        //2.利用线程池，提交
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(myComputeTask);//submit 返回callable,execute 返回 null
        //3.利用Future获取返回值
        System.out.println("sum:"+future.get());
    }
}
class MyComputeTask implements Callable{
    private int sum;

    @Override
    public Object call() throws Exception {
        for (int i=0;i<100;i++){
            sum++;
        }
        return sum;
    }
}
