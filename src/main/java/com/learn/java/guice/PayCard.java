package com.learn.java.guice;

import com.google.inject.Inject;

import lombok.Data;

/**
 * 支付方式
 */
@Data
public class PayCard {

    /**
     * 余额
     */
    private final String account;

    @Inject
    public PayCard(@PaycardAccount String account) {
        this.account = account;
    }
}
