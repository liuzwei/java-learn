package com.learn.java.thread;

import io.netty.util.concurrent.CompleteFuture;

import java.util.concurrent.CompletableFuture;

public class Workable {
    String id;
    final int duration;

    public Workable(String id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable{" +
                "id='" + id + '\'' +
                '}';
    }

    public static Workable work(Workable workable){
        new Nap(workable.duration);
        workable.id = workable.id + "W";
        System.out.println(workable);
        return workable;
    }

    public static CompletableFuture<Workable> make(String id, int duration) {
        return CompletableFuture.completedFuture(new Workable(id, duration))
                .thenApply(Workable::work);
    }



    public static void main(String[] args) {

    }
}
