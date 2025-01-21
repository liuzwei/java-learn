package com.learn.java.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private static final ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100; i++) {
            // 每咯100毫秒向线程池扔两个任务
            Thread.sleep(100);
            for (int j = 0; j < 4; j++) {
                threadPool.execute(() -> {
                    System.out.println("this is a thread "+Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                });
            }
            System.out.println("two threads are finished");
        }
        System.out.println("all threads are finished");
    }
}
