package com.learn.java.thread;

import java.util.concurrent.CompletableFuture;

public class Atomicity {

    public static void test(IntTestable it) {
        new TimeAbort(4, "No Failure Fount");
        CompletableFuture.runAsync(it);
        while (true) {
            int val = it.getAsInt();
            if (val % 2 != 0) {
                System.out.println("FAILURE: " + val);
                System.exit(0);
            }
        }
    }
}
