package com.learn.java.akka.killactor;

import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;
import scala.Option;

/**
 * @author liuzhaowei
 * @date 2022/3/19 15:53
 */
@Slf4j
public class WorkerActor extends UntypedActor {
    // 状态数据
    private int statCount = 1;

    @Override
    public void preStart() throws Exception {
        super.preStart();
        log.info("WorkerActor preStart");
    }

    @Override
    public void onReceive(Object o) throws Exception {
        log.info("WorkerActor receive:{}", o);
        // 模拟计算任务
        this.statCount++;
        if (o instanceof Exception) {
            throw (Exception) o;
        }else if ("getValue".equals(o)) {
            // 返回当前数据
            getSender().tell(statCount, getSelf());
        }else {
            unhandled(o);
        }
    }

    @Override
    public void postStop() throws Exception {
        log.info("WorkerActor stop !");
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        log.info("WorkerActor preRestart begin stateCount={}", this.statCount);
        super.preRestart(reason, message);
        log.info("WorkerActor preRestart end stateCount={}", this.statCount);
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        log.info("WorkerActor postRestart begin stateCount={}", this.statCount);
        super.postRestart(reason);
        log.info("WorkerActor postRestart begin stateCount={}", this.statCount);
    }
}
