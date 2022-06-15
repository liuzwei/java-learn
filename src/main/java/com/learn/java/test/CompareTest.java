package com.learn.java.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaowei
 * @date 2022/4/25 15:33
 */
public class CompareTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("2");
        BigDecimal b2 = new BigDecimal("2");
        System.out.println(b1.compareTo(b2)>=0);
        System.out.println();
        System.out.println(checkContains("7"));

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        Integer reduce = nums.stream().reduce(0, (acc, sum) -> {
            System.out.println("acc: "+acc);
            System.out.println("sum: "+sum);
            return acc + sum;
        });

        System.out.println("sum is :" + reduce);

    }

    private static boolean checkContains(String v){
        String s = "{ \"factorDataType\":\"in-被包含型\", \"factorValue\":[\"1\",\"3\",\"5\",\"7\"] }";
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray factorValue = jsonObject.getJSONArray("factorValue");
        return factorValue.contains(v);
    }
}
