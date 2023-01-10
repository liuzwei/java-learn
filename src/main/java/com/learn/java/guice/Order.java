package com.learn.java.guice;

import com.google.inject.Inject;

import lombok.Data;

/**
 * 订单
 */
@Data
public class Order {

    private final String id;

    private final Double amount;

    @Inject
    public Order(@PayId String id, @PayAmount Double amount) {
        this.id = id;
        this.amount = amount;
    }
}
