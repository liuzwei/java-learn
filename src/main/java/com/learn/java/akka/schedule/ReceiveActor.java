package com.learn.java.akka.schedule;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 18:08
 */
@Slf4j
public class ReceiveActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        log.info("ReceiveActor receive:{}", o);
        getSender().tell("I received!", getSelf());
    }
}
