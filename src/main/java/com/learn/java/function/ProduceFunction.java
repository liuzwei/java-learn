package com.learn.java.function;

import java.util.function.IntSupplier;

/**
 * @author liuzhaowei
 * @date 2022/5/6 21:57
 */
public class ProduceFunction {

    static FunctionSs produce(){
        return (String s)-> {

            return s.toUpperCase();
        };
    }

    public static void main(String[] args) {
        FunctionSs f = produce();

        String abc = f.apply("abc");
        System.out.println(abc);

        IntSupplier supplier = () -> {
            int i = 0;
            i += 1;
            return i;
        };
        for (int i = 0; i < 10; i++) {
            int asInt = supplier.getAsInt();
            System.out.println("i is "+ asInt);
        }
    }
}
