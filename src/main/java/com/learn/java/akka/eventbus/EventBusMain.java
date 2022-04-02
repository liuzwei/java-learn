package com.learn.java.akka.eventbus;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 18:27
 */
@Slf4j
public class EventBusMain {
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("sys");
        ActorRef subActor = sys.actorOf(Props.create(EventSubscribeActor.class), "subActor");
        EventBusDemo bus = new EventBusDemo();
        bus.subscribe(subActor, "info");

        bus.publish(new Event("info", "this is a info message!"));


    }
}
