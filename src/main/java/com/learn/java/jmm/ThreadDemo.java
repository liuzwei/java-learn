package com.learn.java.jmm;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {

    private static final String lock1 = "lock";
    public static class MyThread extends Thread {
        @Override
        public void run() {

        }
    }

    public static class Lock1 implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (lock1) {
                    System.out.println("lock1:"+new Date());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Thread.yield();
            }
        }
    }

    public static class Lock2 implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (lock1) {
                    System.out.println("lock2"+new Date());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Thread.yield();
            }
        }
    }

    public static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return new Date().toString();
        }
    }


    public static void main(String[] args) throws Exception {
//        new MyThread().start();
        Thread thread1 = new Thread(new Lock1());
        Thread thread2 = new Thread(new Lock2());

        System.out.println("thread1:"+thread1.getState());
        System.out.println("thread2:"+thread2.getState());

        thread1.start();
        thread2.start();

        MyCallable myCallable = new MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(myCallable);
        System.out.println("future time:"+future.get());

        while (true){
            System.out.println("thread1:"+thread1.getState());
            System.out.println("thread2:"+thread2.getState());
            Thread.sleep(1000);
        }
    }


}
