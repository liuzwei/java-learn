package com.learn.java.thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuitingCompletable {

    public static final int COUNT = 100;
    public static void main(String[] args) {
        List<QuittableTask> quittableTasks = IntStream.range(0, COUNT)
                .mapToObj(QuittableTask::new)
                .collect(Collectors.toList());

        List<CompletableFuture<Void>> completableFutures = quittableTasks.stream()
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        new Nap(1);
        quittableTasks.forEach(QuittableTask::quit);
        completableFutures.forEach(CompletableFuture::join);
    }
}
