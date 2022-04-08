package com.learn.java.function.collectionutils;

import com.learn.java.function.Function;
import com.learn.java.function.validateemail.Effect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzhaowei
 * @date 2022/4/5 15:07
 */
public class CollectionUtilities<T, U> {
    /**
     * 接收一个List列表和一个函数，并返回处理后的结果
     * @param list
     * @param function
     * @param <T>
     * @param <U>
     * @return
     */
    public static  <T,U> List<U> map(List<T> list, Function<T, U> function) {
        List<U> newList = new ArrayList<>();
        for (T item : list) {
            newList.add(function.apply(item));
        }
        return newList;
    }

    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    public static <T> List<T> list(T t) {
        return Collections.singletonList(t);
    }

    public static <T> List<T> list(List<T> ts) {
        return Collections.unmodifiableList(ts);
    }

    public static <T> List<T> list(T ... t) {
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(t, t.length)));
    }

    /**
     * 头元素
     * @param list
     * @param <T>
     * @return
     */
    public <T> T head(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("head of empty list");
        }
        return list.get(0);
    }

    private static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }

    public static <T> List<T> tail(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("head of empty list");
        }
        List<T> workList = copy(list);
        workList.remove(0);
        return Collections.unmodifiableList(workList);
    }

    /**
     * 添加元素
     * @param list
     * @param item
     * @param <T>
     * @return
     */
    public static <T> List<T> append(List<T> list, T item) {
        List<T> ts = copy(list);
        ts.add(item);
        return Collections.unmodifiableList(ts);
    }

    /**
     * 在列表前面追加一个元素
     * @param t
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> prepend(T t, List<T> list){
        return foldLeft(list, list(t), x -> y -> append(x, y));
    }

    /**
     * 左折叠函数
     * @param list
     * @param identity
     * @param f
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T,U> U foldLeft(List<T> list, U identity, Function<U, Function<T, U>> f ){
        U result = identity;
        for (T item : list) {
            result = f.apply(result).apply(item);
        }
        return result;
    }

    public static <T,U> U foldRight(List<T> list, U identity, Function<T, Function<U, U>> f ){
        U result = identity;
        for (int i=list.size(); i>0; i--) {
            result = f.apply(list.get(i-1)).apply(result);
        }
        return result;
    }

    /**
     * 列表反转
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> reverse(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (int i=list.size()-1; i>=0; i--) {
            newList.add(list.get(i));
        }
        return Collections.unmodifiableList(newList);
    }

    public static <T> List<T> reverse2(List<T> list) {
        return foldLeft(list, list(), x -> y -> prepend(y, x));
    }

    public static <T> void forEach(Collection<T> list, Effect<T> effect) {
        for (T t : list) {
            effect.apply(t);
        }
    }

    /**
     * 生成List
     * @param seed
     * @param f
     * @param check
     * @param <T>
     * @return
     */
    public static <T> List<T> unfold(T seed, Function<T, T> f, Function<T, Boolean> check) {
        List<T> result = new ArrayList<>();
        T temp = seed;
        while (check.apply(temp)){
            result = append(result, temp);
            temp = f.apply(temp);
        }
        return result;
    }


}
