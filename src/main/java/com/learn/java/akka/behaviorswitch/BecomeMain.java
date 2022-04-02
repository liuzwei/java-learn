package com.learn.java.akka.behaviorswitch;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Kill;
import akka.actor.PoisonPill;
import akka.actor.Props;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 12:54
 */
@Slf4j
public class BecomeMain {
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("sys");
        // 创建BecomeActor
        ActorRef becomeActor = sys.actorOf(Props.create(BecomeActor.class), "becomeActor");
        becomeActor.tell("Hello", ActorRef.noSender());
        becomeActor.tell("1", ActorRef.noSender());
        becomeActor.tell("2", ActorRef.noSender());
        becomeActor.tell("3", ActorRef.noSender());
        becomeActor.tell("4", ActorRef.noSender());

        int uid = becomeActor.path().uid();
        log.info("becomeActor uid :{}", uid);
        // 停止一个Actor
        // 1. 通过ActorSystem
        sys.stop(becomeActor);
        // 2. 发送一个PoisonPill消息给Actor
        becomeActor.tell(PoisonPill.getInstance(), ActorRef.noSender());
        // 3. 发送Kill消息
        becomeActor.tell(Kill.getInstance(), ActorRef.noSender());

    }
}
