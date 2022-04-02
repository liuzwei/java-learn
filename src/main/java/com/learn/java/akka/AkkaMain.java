package com.learn.java.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import akka.util.Timeout;
import lombok.extern.slf4j.Slf4j;
import scala.concurrent.Future;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhaowei
 * @date 2022/3/19 11:14
 */
@Slf4j
public class AkkaMain {
    public static void main(String[] args) {
        ActorSystem sys = ActorSystem.create("sys");
        ActorRef customActor = sys.actorOf(Props.create(CustomActor.class), "customActor");
        ActorRef customActor2 = sys.actorOf(Props.create(CustomActor.class), "customActor2");
//        ActorRef customActor2 = sys.actorOf(CustomActor.createProps(), "customActor2");
        ActorRef askActor = sys.actorOf(Props.create(AskActor.class), "askActor");

//        customActor.tell("hello customActor", customActor2);

        Future<Object> hello_askActor = Patterns.ask(askActor, "hello askActor", new Timeout(2, TimeUnit.SECONDS));

        hello_askActor.onSuccess(new OnSuccess<Object>() {
            @Override
            public void onSuccess(Object o) throws Throwable {
                if (o instanceof String) {
                    log.info("响应结果：{}", o.toString());
                }
            }
        }, sys.dispatcher());
        // TargetActor
        ActorRef targetActor = sys.actorOf(Props.create(TargetActor.class), "targetActor");

        // 像ForwardActor发送消息，ForwardActor将消息转发给TargetActor
        ActorRef forwardActor = sys.actorOf(Props.create(ForwardActor.class, targetActor), "forwardActor");
        forwardActor.tell("hello Forward", customActor);

        // 通过路径查找Actor
        ActorSelection actorSelection = sys.actorSelection("akka://sys/user/customActor");
        actorSelection.tell("Hello actor selection", ActorRef.noSender());

        // 向LookupActor发送消息
        ActorRef lookupActor = sys.actorOf(Props.create(LookupActor.class), "lookupActor");
        lookupActor.tell("find", ActorRef.noSender());


    }
}
