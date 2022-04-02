package com.learn.java.akka;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 11:08
 */
@Slf4j
public class CustomActor extends UntypedActor {
    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof String) {
            ActorRef sender = getSender();
            log.info("发送者是{}", sender);
            log.info(msg.toString());
//            sender.tell("Hello, 收到！", getSelf());
        }else {
            unhandled(msg);
        }
    }

    public static Props createProps(){
        return Props.create(new Creator<Actor>() {
            @Override
            public Actor create() throws Exception {
                return Props.empty().newActor();
            }
        });
    }
}
