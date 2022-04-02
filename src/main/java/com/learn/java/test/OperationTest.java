package com.learn.java.test;

/**
 * @author liuzhaowei
 * @date 2022/3/4 9:30
 */
public class OperationTest {
    public static void main(String[] args) {
        long start = System.nanoTime();
        long a = 99999999999999L;
        int b = 9;
        long loopCount = 999999999L;
        for (int i=0; i<loopCount; i++) {
            long s = a / b;
        }
        long end1 = System.nanoTime();
        for (int i=0; i<loopCount; i++) {
            long s = b / a ;
        }
        long end2 = System.nanoTime();

        System.out.println(end1-start);
        System.out.println(end2-end1);
    }
}
