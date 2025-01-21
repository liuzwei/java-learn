package com.learn.java.thread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CacheThreadPool3 {


    public static Integer extractResult(Future<Integer> future) {
        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        // 获取一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 获取一批要处理的任务
//        List<CountingTask> tasks = IntStream.range(0, 10).mapToObj(CountingTask::new).collect(Collectors.toList());

        // 将任务提交到线程池中执行
//        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        // 获取每个任务的结果，并进行求和
//        int sum = futures.stream().map(CacheThreadPool3::extractResult).reduce(0, Integer::sum);

        Integer sum = IntStream.range(0, 10)
                .parallel()
                .mapToObj(CountingTask::new)
                .map(ct -> {
                    try {
                        return ct.call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .reduce(0, Integer::sum);
        System.out.println("sum: " + sum);

        executorService.shutdown();
    }
}
