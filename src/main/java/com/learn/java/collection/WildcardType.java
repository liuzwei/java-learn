package com.learn.java.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 集合最佳实践之使用泛型，占位符规定是数字
 */
public class WildcardType {

    public static double sum(List<? extends Number> list) {
        if (Objects.isNull(list)) {
            return 0;
        }
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        double intValue = sum(Arrays.asList(1,2,3,4,5));
        double longValue = sum(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        // cannot build pass
//        double strValue = sum(Arrays.asList("1", "2", "3", "4", "5"));
        System.out.println(intValue);
        System.out.println(longValue);
    }
}
