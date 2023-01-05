package com.learn.java.jmm;

import java.util.ArrayList;

import com.google.common.collect.Lists;

/**
 * HashCode是否会重复？
 */
public class HashCodeTest {
    public static void main(String[] args) {
        ArrayList<Integer> objectHashCode = Lists.newArrayList();
//        ArrayList<Object> objects = Lists.newArrayList();
        for (int i=0; i<100000; i++){
            Object o = new Object();
            if (objectHashCode.contains(o.hashCode())){
                System.out.println("repeat :"+o.hashCode());
//                objects.add(o);
            }
            objectHashCode.add(o.hashCode());
        }
        System.out.println("repeatList size :"+objectHashCode.size());
    }
}
