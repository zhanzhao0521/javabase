package com.estrus.juc.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {

        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+" completableFuture1");
        });
        completableFuture1.get();
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+" completableFuture2");
            return 1024;
        });
        completableFuture2.whenComplete((t,u)->{
            System.out.println(t);
            System.out.println(u);
        }).get();

    }
}
