package com.learn.java.thread;

import java.util.concurrent.Semaphore;

/**
 * n个线程，轮流对一个数进行累加，每次加1
 */
public class TakeTurnsCounting {

    private static final Semaphore semaphore = new Semaphore(1);

    private static final Object lock = new Object();
    private static int count = 0;
    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            new SemaphoreCountingThread().start();
//        }

        for (int i = 0; i < 3; i++) {
            new SynchronizedCountingThread().start();
        }

    }

    static class SemaphoreCountingThread extends Thread {

        public SemaphoreCountingThread() {
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // 获取信号量，获取不到就阻塞在这里
                    semaphore.acquire();
                    count();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    // 释放信号量
                    semaphore.release();
                }
            }
        }
    }

    static class SynchronizedCountingThread extends Thread {
        public SynchronizedCountingThread() {
        }
        @Override
        public void run() {
            synchronized (lock) {
                count();
            }
        }
    }

    private static void count(){
        while (true) {
            if (count == 10) {
                break;
            }
            count += 1;
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }

}
