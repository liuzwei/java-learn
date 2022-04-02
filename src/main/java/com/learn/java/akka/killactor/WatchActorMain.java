package com.learn.java.akka.killactor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 16:02
 */
@Slf4j
public class WatchActorMain {
    public static void main(String[] args) {
        // 创建根
        ActorSystem sys = ActorSystem.create("sys");
        ActorRef watchActor = sys.actorOf(Props.create(WatchActor.class), "watchActor");
        // 向watchActor发送终止消息
//        watchActor.tell("stopChild", ActorRef.noSender());

        // 创建SupervisorActor
        ActorRef supervisorActor = sys.actorOf(Props.create(SupervisorActor.class), "supervisorActor");

    }
}
