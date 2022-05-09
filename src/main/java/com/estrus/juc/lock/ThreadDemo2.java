package com.estrus.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share{
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"::"+num);
        }finally {
            condition.signalAll();
        }


    }
    public void decr() throws InterruptedException {
        lock.lock();
        try {
            while (num!=1){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"::"+num);
        }finally {
            condition.signalAll();
        }


    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
       Share share = new Share();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    try {
                        share.incr();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    try {
                        share.decr();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    try {
                        share.incr();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"CC").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    try {
                        share.decr();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"DD").start();
    }
}
