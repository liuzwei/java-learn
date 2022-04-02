package com.learn.java.test;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuzhaowei
 * @date 2022/2/16 11:10
 */
public class TestStreamSort {
    /**
     * 测试Stream按时间排序
     * @param args
     */
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i=1; i<10; i++) {
            Student student = new Student();
            student.setName(String.valueOf(i));
            LocalDateTime now = LocalDateTime.now();
            student.setDate(now.minusMinutes(i));
            list.add(student);
        }

        List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getDate)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Data
    static class Student {
        String name;
        LocalDateTime date;
    }
}
