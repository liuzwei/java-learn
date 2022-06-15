package com.learn.java.function;

@FunctionalInterface
public interface TriFunction<T,U,V,R> {

    R apply(T t, U u, V v);

}
