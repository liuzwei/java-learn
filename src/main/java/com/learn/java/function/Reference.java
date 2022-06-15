package com.learn.java.function;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author liuzhaowei
 * @date 2022/5/5 23:54
 */
public class Reference {
    public static void main(String[] args) {
        MakeNoArgs noArgs = Dog::new;
        MakeOneArgs oneArgs = Dog::new;

        Dog dog = noArgs.make();
        Dog xiaoHua = oneArgs.make("XiaoHua");

        Predicate<String> predicate = (String a) -> {
            return false;
        };

        BiPredicate<String,Long> biPredicate = (String s, Long l) -> {

            return false;
        };
    }
}
