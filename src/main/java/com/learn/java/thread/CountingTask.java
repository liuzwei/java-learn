package com.learn.java.thread;

import java.util.concurrent.Callable;

public class CountingTask implements Callable<Integer> {

    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        int value = 0;

        for (int i = 0; i < 100; i++) {
            value += 1;
        }
        System.out.println(id +" " + Thread.currentThread().getName() + " " + value);
        return value;
    }
}
