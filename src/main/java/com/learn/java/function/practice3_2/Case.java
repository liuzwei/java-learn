package com.learn.java.function.practice3_2;

import com.learn.java.function.validateemail.Result;
import com.learn.java.tuple.Tuple;

import java.util.function.Supplier;

/**
 * @author liuzhaowei
 * @date 2022/4/2 13:26
 */
public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {

    private Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
        super(booleanSupplier, resultSupplier);
    }


    private static class DefaultCase<T> extends Case<T> {

        private DefaultCase(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
            super(booleanSupplier, resultSupplier);
        }
    }

    public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value){
        return new Case<>(condition, value);
    }

    public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
        return new DefaultCase<>(()-> true, value);
    }

    @SafeVarargs
    public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... matchers) {
        for (Case<T> aCase : matchers) {
            if (aCase._1.get()) {
                return aCase._2.get();
            }
        }
        return defaultCase._2.get();
    }
}
