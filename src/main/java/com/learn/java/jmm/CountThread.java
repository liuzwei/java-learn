package com.learn.java.jmm;

public class CountThread {

    private static volatile Integer count = 0;

    private static Object lock = new Object();

    public static class CountThreadA implements Runnable {

        @Override
        public void run() {
//            synchronized (lock) {
                for (int i = 1; i <= 10000; i++) {
                    count = count + i;
                }
//            }
        }
    }

    public static class CountThreadB implements Runnable{

        @Override
        public void run() {
//            synchronized (lock) {
            for (int i = 1; i <= 10000; i++) {
                count = count + i;
            }
//            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread threadA = new Thread(new CountThreadA());
        Thread threadB = new Thread(new CountThreadB());

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println(count);
    }
}
