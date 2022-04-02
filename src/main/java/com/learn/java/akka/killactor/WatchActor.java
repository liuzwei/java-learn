package com.learn.java.akka.killactor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 15:55
 */
@Slf4j
public class WatchActor extends UntypedActor {

    private ActorRef workActor;
    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof String) {
            log.info("WatchActor receive:{}", o);
            if ("stopChild".equals(o)) {
                getContext().stop(workActor);
            }
        }else if (o instanceof Terminated) {
            Terminated terminated = (Terminated) o;
            log.info("监控到{}停止了", terminated.actor());
        }else {
            unhandled(o);
        }
    }

    @Override
    public void preStart() throws Exception {
        // 创建子级Actor
        workActor = getContext().actorOf(Props.create(WorkerActor.class), "workerActor");
        // 监控子Actor
        getContext().watch(workActor);
    }

    @Override
    public void postStop() throws Exception {
        log.info("WatchActor stop !");
    }
}
