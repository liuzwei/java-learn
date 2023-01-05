package com.learn.java.jmm;

public class MultiThreadLong {

    private static long t = 0;

    /**
     * 写线程
     */
    static class WriteThread implements Runnable {
        private long t0;

        public WriteThread(long t0) {
            this.t0 = t0;
        }

        @Override
        public void run() {
            while (true){
                MultiThreadLong.t = t0;
                // 让出时间片
                Thread.yield();
            }
        }
    }
    static class ReadThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                long temp = MultiThreadLong.t;
                if (temp != 999L && temp != -1111L && temp != 555555L && temp != 1000000L){
                    System.out.println(temp);
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Thread(new WriteThread(999)).start();
        new Thread(new WriteThread(-1111L)).start();
        new Thread(new WriteThread(555555L)).start();
        new Thread(new WriteThread(1000000L)).start();

        new Thread(new ReadThread()).start();
    }
}
