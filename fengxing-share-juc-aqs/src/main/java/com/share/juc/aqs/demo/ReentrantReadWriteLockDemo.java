package com.share.juc.aqs.demo;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReentrantReadWriteLockDemo
 * @Description 读写锁demo
 * @Author fengxing
 * @Date 2020/10/12 11:40
 * @Version V1.0
 **/
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        final MyTreeMap myTreeMap=new MyTreeMap();
        new Thread(()->{
            for (int i=0;i<300;i++){
                System.out.println("插入"+i);
                myTreeMap.put("mapKey"+i,"value"+i);
            }
        }).start();
        //new Thread((()->System.out.println("获取mapKey1的值"+myTreeMap.get("mapKey1").toString()))).start();
        new Thread((()->System.out.println("获取mapKeys的值"+myTreeMap.allKeys().toString()))).start();
        /*threadPoolExecutor.submit((()->System.out.println("获取mapKey1的值"+myTreeMap.get("mapKey1").toString())));
        threadPoolExecutor.submit((()->System.out.println("获取mapKey1的值"+myTreeMap.get("mapKey1").toString())));
        threadPoolExecutor.submit((()->System.out.println("获取mapKeys的值"+myTreeMap.allKeys().toString())));*/
    }
}
class MyTreeMap{
    private final Map<String, Object> m = new TreeMap<String, Object>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();//读锁
    private final Lock w = rwl.writeLock();//写锁

    public Object get(String key) {
        r.lock();
        try { return m.get(key); }
        finally { r.unlock(); }
    }
    public Object allKeys() {
        r.lock();
        try { return  m.keySet().toString(); }
        finally { r.unlock(); }
    }
    public Object put(String key, Object value) {
        w.lock();
        try { return m.put(key, value); }
        finally { w.unlock(); }
    }
    public void clear() {
        w.lock();
        try { m.clear(); }
        finally { w.unlock(); }
    }
}