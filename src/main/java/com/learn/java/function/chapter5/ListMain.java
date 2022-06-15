package com.learn.java.function.chapter5;

import com.google.common.base.Function;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/4/12 21:33
 */
@Slf4j
public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = List.list(1, 2, 3, 4, 5);
        log.info("custom list is :{}", list);
    }

    static Function<List<Integer>, Double> mean = xs -> {
        if (xs.isEmpty()){
            return Double.NaN;
        }else {
            return 0D;
        }
    };


}
