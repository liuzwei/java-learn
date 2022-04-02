package com.learn.java.akka.behaviorswitch;

import akka.actor.UntypedActor;
import akka.japi.Procedure;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试行为切换
 * @author liuzhaowei
 * @date 2022/3/19 12:50
 */
@Slf4j
public class BecomeActor extends UntypedActor {

    Procedure<Object> procedure = new Procedure<Object>(){
        @Override
        public void apply(Object o) throws Exception {
            log.info("become : {}", o.toString());
            getContext().unbecome();
        }
    };

    @Override
    public void onReceive(Object o) throws Exception {
        log.info("BecomeActor receive:{}", o.toString());
        getContext().become(procedure);
        log.info("-------------------------------");
    }

    @Override
    public void postStop() throws Exception {
        log.info("Worker poststop");
    }
}
