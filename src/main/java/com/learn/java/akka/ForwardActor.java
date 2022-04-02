package com.learn.java.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 11:59
 */
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ForwardActor extends UntypedActor {
    private ActorRef target ;
    @Override
    public void onReceive(Object o) throws Exception {
        target.forward(o, getContext());
    }
}
