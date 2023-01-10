package com.learn.java.guice;

import com.google.inject.Inject;

import lombok.Data;

@Data
public class WechatPayService implements PayService{

    private final Order order;
    private final PayCard card;

    @Inject
    public WechatPayService(Order order, PayCard card) {
        this.order = order;
        this.card = card;
    }

    @Override
    public void pay() {
        System.out.println("order id is :" + order.getId());
        System.out.println("order amount is :" + order.getAmount());
        System.out.println("card account is :" + card.getAccount());
    }
}
