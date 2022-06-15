package com.learn.java.test;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuzhaowei
 * @date 2022/6/14 21:13
 */
public class TestThreadLocal {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        for (int i=1; i<999999999; i++) {
            threadPool.submit(new MyThread(i));
        }
        System.out.println("over");
    }

    static class MyThread implements Runnable {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            ThreadLocal<String> stringTl = new ThreadLocal<>();
            stringTl.set(Thread.currentThread().getName()+index);

            ThreadLocal<Integer> intTl = ThreadLocal.withInitial(() -> 10);
            intTl.set(100);

            ThreadLocal<Map<String, Object>> mapTl = new ThreadLocal<>();
//        mapTl.get().put("name", "THREAD_LOCAL");


            System.out.println(stringTl.get());
//            System.out.println(intTl.get());
//            System.out.println(mapTl.get());
        }
    }
}
