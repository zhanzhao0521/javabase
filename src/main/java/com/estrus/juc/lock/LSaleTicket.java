package com.estrus.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int number = 120;

    ReentrantLock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (number>0){
                System.out.println(Thread.currentThread().getName()+" : 卖出："+(number--)+"剩下："+number);
            }
        }finally {
            lock.unlock();
        }
    }
}
public class LSaleTicket {
    public static void main(String[] args) {
       Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"CC").start();
    }
}
