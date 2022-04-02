package com.learn.java.akka;

import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.Identify;
import akka.actor.Props;
import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzhaowei
 * @date 2022/3/19 12:18
 */
@Slf4j
public class LookupActor extends UntypedActor {

    private ActorRef target = null;
    {
        target = getContext().actorOf(Props.create(TargetActor.class), "targetActor");
    }
    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof String) {
            if ("find".equals(o.toString())) {
//                ActorSelection selection = getContext().actorSelection("targetActor");
                ActorSelection selection = getContext().actorSelection("akka://sys/user/targetActor");
                selection.tell(new Identify("A001"), getSelf());
            }
        }else if (o instanceof ActorIdentity) {
            ActorIdentity identity = (ActorIdentity) o;
            if (identity.correlationId().equals("A001")) {
                ActorRef targetRef = identity.getRef();
                if (targetRef != null) {
                    log.info("ActorIdentity:{}，targetRef:{}", identity.correlationId(), targetRef);
                    targetRef.tell("hello target", getSelf());
                }
            }
        }else {
            unhandled(o);
        }
    }
}
