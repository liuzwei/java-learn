package com.learn.java.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuitingTasks {

    public static final int COUNT = 100;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<QuittableTask> quittableTasks = IntStream.range(0, COUNT)
                .mapToObj(QuittableTask::new)
                .peek(executorService::execute)
                .collect(Collectors.toList());
        new Nap(1);
        quittableTasks.forEach(QuittableTask::quit);
        executorService.shutdown();
    }
}
