package com.learn.java.jmm;

public class WaitAndNotify {
    /**
     * 一个锁对象
     */
    private static Object lock = new Object();

    public static class ThreadA implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("ThreadA " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                lock.notify();
            }
        }
    }

    public static class ThreadB implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("ThreadB " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}
