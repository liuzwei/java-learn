package com.learn.java.thread;

public class TestAbort {

    public static void main(String[] args) {
        new TimeAbort(1);
        System.out.println("Napping for 4");
        new Nap(4);
    }
}
