package com.learn.java.thread;

import java.util.function.IntSupplier;

public abstract class IntTestable implements Runnable, IntSupplier {

    abstract  void evenIncrement();
    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}
