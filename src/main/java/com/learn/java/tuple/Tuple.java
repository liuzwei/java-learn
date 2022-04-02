package com.learn.java.tuple;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.google.common.base.Optional;
import lombok.Data;

/**
 * @author liuzhaowei
 * @date 2022/3/31 1:33
 */
@Data
public class Tuple<T,U> {
    public final T _1;
    public final U _2;

}
