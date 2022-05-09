package com.estrus.juc.util;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static final int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            System.out.println("*****集齐"+NUMBER+"颗龙珠就可以召唤神龙了*****");
        });
        for (int i = 1; i <= NUMBER; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"星龙被收集到了");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();

        }
    }
}
