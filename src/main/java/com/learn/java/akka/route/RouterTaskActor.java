package com.learn.java.akka.route;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaowei
 * @date 2022/3/19 17:52
 */
@Slf4j
public class RouterTaskActor extends UntypedActor {
    private Router router;

    @Override
    public void preStart() throws Exception {
        List<Routee> listRoutee = new ArrayList<>();
        for (int i=0; i<2; i++) {
            ActorRef actorRef = getContext().actorOf(Props.create(RouteeActor.class), "routeeActor" + i);
            listRoutee.add(new ActorRefRoutee(actorRef));
        }
        // 实例化一个路由器，指定路由策略和路由目标集合
        router = new Router(new RoundRobinRoutingLogic(), listRoutee);
    }

    @Override
    public void onReceive(Object o) throws Exception {
        router.route(o, getSender());
    }
}
