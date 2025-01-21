package com.learn.java.thread;

import java.util.concurrent.TimeUnit;

public class Nap {

    public Nap(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((long) (1000 * t));
        }catch (Exception e) {

        }
    }

    public Nap(double t, String s) {
        new Nap(t);
        System.out.println(s);
    }
}
