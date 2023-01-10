package com.learn.java.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class PayModule extends AbstractModule {

    @Provides
    @PayId
    static String providerPyId(){
        return "pay_id_123456";
    }

    @Provides
    @PayAmount
    static Double providerAmount(){
        return 12.12;
    }

    @Provides
    @PaycardAccount
    static String providerPayAccount(){
        return "wechat_2001234";
    }

    @Override
    protected void configure() {
        // 绑定实现类
        bind(PayService.class).to(WechatPayService.class);
    }
}
