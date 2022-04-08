package com.learn.java.function;

import com.learn.java.function.collectionutils.CollectionUtilities;
import com.learn.java.function.validateemail.Effect;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * @author liuzhaowei
 * @date 2022/4/6 13:29
 */
@Slf4j
public class ComposeMapTest {
    /**
     * 说明：
     * 有一批价格表，对购买的人征收9%的税，然后增加3.5元的固定运费
     * @param args
     */
    public static void main(String[] args) {
        List<Double> priceList = CollectionUtilities.list(10.5,6.8,99.9,100.99);
        // 计算加税后的价格
        List<Double> addTaxPrice = CollectionUtilities.map(priceList, addTax);
        // 计算增加固定费用后的价格
        List<Double> addShippingPrice = CollectionUtilities.map(addTaxPrice, addShipping);
        log.info("税后价格：{}", addTaxPrice);
        log.info("税后+固定运费价格：{}", addShippingPrice);
        //运用复合函数
        List<Double> doubles = CollectionUtilities.map(priceList, addTax.andThen(addShipping));
        log.info("符合函数税后+固定运费价格：{}", doubles);

        // 对数据格式化
        CollectionUtilities.forEach(doubles, printWith2decimals);

        CollectionUtilities.list(1,2,3,4,5).forEach(System.out::println);
    }

    /**
     * 定义一个作用，用来格式化小数
     */
    static Effect<Double> printWith2decimals = x -> {
        System.out.printf("%.2f", x);
        System.out.println();
    };
    /**
     * 定义增加9%税的函数
     */
    static Function<Double, Double> addTax = x -> x*(1+0.09);
    /**
     * 定义增加3.5固定运费的函数
     */
    static Function<Double, Double> addShipping = x -> x + 3.5;
}
