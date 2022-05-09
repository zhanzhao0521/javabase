package com.estrus.juc.util;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int count = 6;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 1; i <= count; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学离开了教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+" 班长锁门走人了");
    }
}
