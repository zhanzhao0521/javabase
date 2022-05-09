package com.estrus.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写操作"+key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写完了"+key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }

    }
    public Object get(String key){
        rwLock.readLock().lock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName()+"正在读操作"+key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读完了"+key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
        return result;
    }


}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i < 5; i++) {
            int num = i;
            new Thread(()->{
                myCache.put(num+"",num);
            },String.valueOf(i)).start();
        }
        for (int i = 1; i < 5; i++) {
            int num = i;
            new Thread(()->{
                myCache.get(num+"");
            },String.valueOf(i)).start();
        }
    }
}
