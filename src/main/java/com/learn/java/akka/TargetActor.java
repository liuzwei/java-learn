package com.learn.java.akka;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 11:58
 */
@Slf4j
public class TargetActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
      log.info("Target actor receive:{}， sender is {}", o.toString(), getSender());
    }
}
