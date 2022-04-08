package com.learn.java.function;

import java.util.Objects;

public interface Function<T, U> {
    U apply(T t);

    default <V> Function<T, V> andThen(Function<? super U, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
}
