package com.learn.java.akka.killactor;

import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.japi.Function;
import lombok.extern.slf4j.Slf4j;
import scala.concurrent.duration.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuzhaowei
 * @date 2022/3/19 16:28
 */
@Slf4j
public class SupervisorActor extends UntypedActor {
    // 子Actor
    private ActorRef workActor=null;
    // 定义监督策略
    SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create("1 minute"), new Function<Throwable, SupervisorStrategy.Directive>() {
        @Override
        public SupervisorStrategy.Directive apply(Throwable throwable) throws Exception {
            if (throwable instanceof IOException) {
                log.info("=============IOException==============");
                return SupervisorStrategy.resume();
            } else if (throwable instanceof IndexOutOfBoundsException) {
                log.info("=============IndexOutOfBoundsException==============");
                return SupervisorStrategy.restart();
            } else if (throwable instanceof SQLException) {
                log.info("=============SQLException==============");
                return SupervisorStrategy.stop();
            }else {
                return SupervisorStrategy.escalate();
            }
        }
    });

    @Override
    public void preStart() throws Exception {
        workActor = getContext().actorOf(Props.create(WorkerActor.class), "workerActor");
        getContext().watch(workActor);
        // 向workActor发消息
//        workActor.tell(new IOException(), getSelf());
//        workActor.tell(new SQLException("SQL异常"), getSelf());
//        workActor.tell(new IndexOutOfBoundsException(), getSelf());
        workActor.tell("getValue", getSelf());
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return this.strategy;
    }

    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof Terminated) {
            Terminated terminated = (Terminated) o;
            log.info("{}已经终止", terminated.actor());
        }else {
            log.info("stateCount={}", o);
        }
    }
}
