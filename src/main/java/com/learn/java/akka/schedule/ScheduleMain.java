package com.learn.java.akka.schedule;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import lombok.extern.slf4j.Slf4j;
import scala.concurrent.duration.Duration;

/**
 * @author liuzhaowei
 * @date 2022/3/19 18:10
 */
@Slf4j
public class ScheduleMain {
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("sys");
        ActorRef sendActor = sys.actorOf(Props.create(SendActor.class), "sendActor");
        ActorRef receiveActor = sys.actorOf(Props.create(ReceiveActor.class), "receiveActor");

        sys.scheduler().scheduleOnce(Duration.create(5, "s"), receiveActor, "Hello ReceiveActor", sys.dispatcher(), sendActor);
    }
}
