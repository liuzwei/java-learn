package com.learn.java.jmm;

public class volatileTest {

    private static volatile Integer open = new Integer(0);
    private static volatile Integer  open2;

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            System.out.println("t1 open is "+ open);
            open2 = open;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1 open2 is "+ open2);
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 open is "+ open);
            open = 1;
            System.out.println("t2 open is "+ open);
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
