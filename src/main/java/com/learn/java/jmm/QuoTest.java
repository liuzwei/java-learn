package com.learn.java.jmm;

import lombok.Data;

public class QuoTest {
    private static MyNum num = new MyNum(0);

    public static void main(String[] args) throws Exception{
//        System.out.println("1 -- num = "+num);
//        MyNum num2 = num;
//        System.out.println("2 -- num2 = "+num2);
//        num.setNum(30);
//        System.out.println("3 -- num = "+num);
//        System.out.println("4 -- num2 = "+num2);


        Thread t1 = new Thread(() -> {
            System.out.println("t1 num is "+ num.getNum());
            MyNum num2 = num;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1 num2 is "+ num2.getNum());
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 num is "+ num.getNum());
            num.setNum(1);
            System.out.println("t2 num is "+ num.getNum());
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    @Data
    public static class MyNum {
        Integer num;

        public MyNum(Integer num) {
            this.num = num;
        }
    }
}
