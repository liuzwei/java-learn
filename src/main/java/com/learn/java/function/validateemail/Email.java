package com.learn.java.function.validateemail;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuzhaowei
 * @date 2022/4/1 22:33
 */
@Data
@AllArgsConstructor
public class Email implements Serializable {
    private String address;
}
