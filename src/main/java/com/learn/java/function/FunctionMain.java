package com.learn.java.function;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * @author liuzhaowei
 * @date 2022/3/31 22:14
 */
@Slf4j
public class FunctionMain {

    /**
     *  参数乘以3
     */
    Function<Integer, Integer> triple = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return integer * 3;
        }
    };

    /**
     * 参数的平方
     */
    Function<Integer, Integer> square = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return integer * integer;
        }
    };

    // 复合两个函数
    static Function<Integer, Integer> compose(Function<Integer, Integer> triple, Function<Integer, Integer> square) {
        return arg -> triple.apply(square.apply(arg));
    }

    // 求和函数
    Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;

    public static void main(String[] args) {
        FunctionMain functionMain = new FunctionMain();
        Integer triple = functionMain.triple.apply(3);
        Integer square = functionMain.square.apply(3);
        log.info("triple value is {}, square value is {}", triple, square);

        Integer apply = compose(functionMain.triple, functionMain.square).apply(3);
        Integer apply1 = compose(functionMain.square, functionMain.triple).apply(3);
        log.info("apply value is {}, apply1 value is {}", apply, apply1);

        // 求和函数
        Integer apply2 = functionMain.add.apply(10).apply(20);
        log.info("apply2 value is {}", apply2);



    }
}
