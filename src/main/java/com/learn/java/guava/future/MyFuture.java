package com.learn.java.guava.future;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhaowei
 * @date 2022/3/30 21:55
 */
@Slf4j
public class MyFuture {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<List<Student>> searchStudent = listeningExecutorService.submit(() -> {
            // 模拟查询学生信息
            Thread.sleep(3000);
            List<Student> list = new ArrayList<>();
            for (int i=0; i<5; i++) {
                list.add(new Student("student"+i,10));
            }
            return  list;
        });

        // 模拟查询完学生信息后，对学生信息处理
        ListenableFuture<List<Student>> handleStudent = Futures.transform(searchStudent, students -> {
            for (int i=0; i<students.size(); i++) {
                students.get(i).setAge(i+10);
            }
            return students;
        }, MoreExecutors.directExecutor());

        // 模拟对处理完的信息进行使用
        FutureCallback<List<Student>> futureCallback = new FutureCallback<List<Student>>() {
            @Override
            public void onSuccess(@Nullable List<Student> result) {
                for (Student student : result) {
                    log.info("student is {}", student);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        };
        Futures.addCallback(handleStudent, futureCallback, executorService);
        log.info("it's over!");

    }

    // old api
    public FutureTask<String> fetchConfigTask(String configKey) {
        return new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return String.format("%s.%d", configKey, new Random().nextInt(Integer.MAX_VALUE));
        });
    }

    // new api
    public ListenableFutureTask<String> fetchConfigListenableTask(String configKey) {
        return ListenableFutureTask.create(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return String.format("%s.%d", configKey, new Random().nextInt(Integer.MAX_VALUE));
        });
    }
}
