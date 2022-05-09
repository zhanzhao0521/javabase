package com.estrus.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer>{
    private static final Integer VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin,int end){
        this.begin = begin;
        this.end = end;
    }


    @Override
    protected Integer compute() {

        if ((end - begin) <= VALUE){
            for (int i = begin; i <= end ; i++) {
                result = result + i;
            }
        }else {
            int middle = (begin + end)/2;
            MyTask myTask1 = new MyTask(begin, middle);
            MyTask myTask2 = new MyTask(middle+1, end);
            myTask1.fork();
            myTask2.fork();
            result = myTask1.join() + myTask2.join();
        }

        return result;
    }


}
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        //countForkJoin(0,1000000);
        count(0,100);
        System.out.println(System.currentTimeMillis() - start);
    }
    public static Integer countForkJoin(int begin,int end) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(begin, end);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        Integer result = forkJoinTask.get();
        System.out.println(result);
        forkJoinPool.shutdown();
        return  result;
    }
    public static Integer count(int begin,int end){
        int result = 0;
        for (int i = begin; i <= end; i++) {
            result = result + i;
        }
        return result;
    }
}
