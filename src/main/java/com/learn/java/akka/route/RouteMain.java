package com.learn.java.akka.route;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 17:58
 */
@Slf4j
public class RouteMain {
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("sys");
        ActorRef routerTaskActor = sys.actorOf(Props.create(RouterTaskActor.class), "routerTaskActor");
        routerTaskActor.tell("Hello A", ActorRef.noSender());
        routerTaskActor.tell("Hello B", ActorRef.noSender());
        routerTaskActor.tell("Hello C", ActorRef.noSender());
        routerTaskActor.tell("Hello D", ActorRef.noSender());
    }
}
