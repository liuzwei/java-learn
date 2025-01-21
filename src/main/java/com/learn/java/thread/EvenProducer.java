package com.learn.java.thread;

public class EvenProducer extends IntGenerator{

    private int currentEvenValue = 0;
    @Override
    public  int next() {
        currentEvenValue++;
        new Nap(0.01);
        currentEvenValue++;

        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenProducer());
    }
}
