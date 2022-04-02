package com.learn.java.akka.eventbus;

import akka.actor.ActorRef;
import akka.event.japi.LookupEventBus;

/**
 * @author liuzhaowei
 * @date 2022/3/19 18:22
 */
public class EventBusDemo extends LookupEventBus<Event, ActorRef, String> {
    @Override
    public int mapSize() {
        return 8;
    }

    @Override
    public int compareSubscribers(ActorRef actorRef, ActorRef s1) {
        return actorRef.compareTo(s1);
    }

    @Override
    public String classify(Event event) {
        return event.getType();
    }

    @Override
    public void publish(Event event, ActorRef actorRef) {
        actorRef.tell(event.getMessage(), ActorRef.noSender());
    }
}
