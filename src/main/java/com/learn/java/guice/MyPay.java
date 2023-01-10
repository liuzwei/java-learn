package com.learn.java.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MyPay {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PayModule());
        PayService instance = injector.getInstance(PayService.class);

        Order order = injector.getInstance(Order.class);
        PayCard payCard = injector.getInstance(PayCard.class);


        instance.pay();
    }
}
