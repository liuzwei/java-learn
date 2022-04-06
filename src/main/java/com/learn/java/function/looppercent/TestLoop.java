package com.learn.java.function.looppercent;

import com.learn.java.function.Function;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaowei
 * @date 2022/4/5 14:49
 */
@Slf4j
public class TestLoop {

    /**
     * 对List中的每个元素增加20%
     * @param args
     */
    public static void main(String[] args) {
        // 构造一个List，并对每个元素增加20%
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<11; i++) {
            list.add(i);
        }

        // 第一种方法
        List<Double> newList = add20percentForList(list);
        log.info("newlist items: {}", newList);

        // 第二种方法
        List<Double> newList2 = add20percentForList2(list);
        log.info("newList2 items: {}", newList2);

        // 第三种方法
        List<Double> newList3 = add20percentForList3(list, TestLoop::add20percentForItem);
        log.info("newList3 items: {}", newList3);
    }

    /**
     * 一般操作
     * @param list
     */
    public static List<Double> add20percentForList(List<Integer> list) {
        List<Double> newList = new ArrayList<>();
        for (Integer item : list) {
            double newItem = item * 1.2;
            newList.add(newItem);
        }
        return newList;
    }

    /**
     * 将计算函数提到方法外面,计算可以实现重用
     * @param list
     * @return
     */
    public static List<Double> add20percentForList2(List<Integer> list) {
        List<Double> newList = new ArrayList<>();
        for (Integer item : list) {
            newList.add(add20percentForItem(item));
        }
        return newList;
    }

    /**
     * 计算，每个元素增加20%
     * @param item
     * @return
     */
    public static Double add20percentForItem(Integer item) {
        return item * 1.2;
    }

    Function<Integer, Double> add20percentForItem2 = x -> x * 1.2;
    /**
     * 把循环放到方法里，传一个函数进去，应用计算
     */
    public static List<Double> add20percentForList3(List<Integer> list, Function<Integer, Double> f) {
        List<Double> newList = new ArrayList<>();
        for (Integer item : list) {
            newList.add(f.apply(item));
        }
        return newList;
    }
}
