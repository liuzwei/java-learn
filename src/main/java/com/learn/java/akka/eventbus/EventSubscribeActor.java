package com.learn.java.akka.eventbus;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * EventBus订阅的Actor
 * @author liuzhaowei
 * @date 2022/3/19 18:28
 */
@Slf4j
public class EventSubscribeActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        log.info("{}---->{}", getSelf(), o);
    }
}
