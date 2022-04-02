package com.learn.java.akka;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 11:44
 */
@Slf4j
public class AskActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof String) {
            log.info(o.toString());
            getSender().tell("hello", getSelf());
        }else {
            unhandled(o);
        }
    }
}
