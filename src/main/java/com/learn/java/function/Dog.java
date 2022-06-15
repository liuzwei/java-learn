package com.learn.java.function;

import lombok.Data;

/**
 * @author liuzhaowei
 * @date 2022/5/5 23:53
 */
@Data
public class Dog {
    private String name;

    Dog() {
    }

    Dog(String name) {
        this.name = name;
    }
}
