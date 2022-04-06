package com.learn.java.function.collectionutils;

import com.learn.java.function.Function;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhaowei
 * @date 2022/4/6 10:59
 */
@Slf4j
public class CollectionTest {

    Function<Integer, Integer> add = x -> x;
    /**
     * 定义一个求和函数
     * @param args
     */
    static Function<Integer, Function<Integer, Integer>> addFunction = x -> y -> x+y;
    /**
     * 求乘积函数
     */
    static Function<Integer, Function<Integer, Integer>> multiFunction = x -> y -> x*y;

    /**
     * 左折叠函数
     */
    static Function<String, Function<Integer, String>> strLeft = x -> y -> "("+x+" + "+y+")";
    /**
     * 右折叠函数
     */
    static Function<Integer, Function<String, String>> strRight = x -> y -> "("+x+" + "+y+")";

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Integer fold = CollectionUtilities.foldLeft(list, 0, addFunction);
        log.info("求和得：{}", fold);

        Integer multi = CollectionUtilities.foldLeft(list, 1, multiFunction);
        log.info("求积得：{}", multi);

        String addLeft = CollectionUtilities.foldLeft(list, "0", strLeft);
        log.info("左叠加：{}", addLeft);
        String addRight = CollectionUtilities.foldRight(list, "0", strRight);
        log.info("右叠加：{}", addRight);

        // 列表反转
        log.info("list reverse:{}",CollectionUtilities.reverse(list));
        log.info("list reverse2:{}",CollectionUtilities.reverse2(list));

        // 列表前追加元素
        List<Integer> prepend = CollectionUtilities.prepend(100, list);
        log.info("list prepend:{}",prepend);
    }
}
