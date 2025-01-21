package com.learn.java.thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenChecker implements Runnable{

    private IntGenerator generator;
    private int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int i = generator.next();
            if (i % 2 != 0) {
                System.out.println(i + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        List<CompletableFuture<Void>> evenCheckerFutures = IntStream.range(0, count)
                .mapToObj(i -> new EvenChecker(generator, i))
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        evenCheckerFutures.forEach(CompletableFuture::join);
    }

    public static void test(IntGenerator generator) {
        test(generator, MachineProcessor.machineProcessor());
    }
}
