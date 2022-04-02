package com.learn.java.akka.schedule;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 18:07
 */
@Slf4j
public class SendActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        log.info("SendActor 收到回应消息：{}", o);
    }
}
