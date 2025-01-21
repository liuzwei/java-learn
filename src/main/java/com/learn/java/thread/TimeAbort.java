package com.learn.java.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TimeAbort {
    private volatile boolean restart = true;

    public TimeAbort(double t, String msg) {
        CompletableFuture.runAsync(() -> {
            try {
                while (restart) {
                    restart = false;
                    TimeUnit.MILLISECONDS.sleep((long) (1000 * t));
                }
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg);
            System.exit(0);
        });
    }

    public TimeAbort(double t) {
        this(t, "TimeAbort " + t);
    }

    public  void restart() {
        restart = true;
    }

}
