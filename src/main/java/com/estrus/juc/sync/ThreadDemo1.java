package com.estrus.juc.sync;


class Share{

    private int num = 0;

    public synchronized void incr() throws InterruptedException {
        while (num != 0 ){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"::"+num);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        while (num != 1 ){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"::"+num);
        this.notifyAll();
    }


}
public class ThreadDemo1 {

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
