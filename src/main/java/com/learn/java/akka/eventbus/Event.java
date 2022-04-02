package com.learn.java.akka.eventbus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuzhaowei
 * @date 2022/3/19 18:21
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Event {
    private String type;
    private String message;
}
