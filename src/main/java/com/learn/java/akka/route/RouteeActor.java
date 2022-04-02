package com.learn.java.akka.route;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 17:50
 */
@Slf4j
public class RouteeActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        log.info("{}------>{}", getSelf(), o);
    }
}
