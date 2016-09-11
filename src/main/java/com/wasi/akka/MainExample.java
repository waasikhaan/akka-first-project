package com.wasi.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinRouter;
import com.wasi.akka.actor.MessageEchoActor;

import java.util.concurrent.TimeUnit;

/**
 * Created by wasikhan on 5/16/2016.
 */
public class MainExample {

    public static void main(String[] args) throws InterruptedException {
        ActorSystem _system = ActorSystem.create("RoundRobinRouterExample");
        ActorRef roundRobinRouter = _system.actorOf(new Props(
                MessageEchoActor.class).withRouter(new RoundRobinRouter(5)), "myRoundRobinRouterActor");

        for (int i = 1; i <= 1000; i++) {
            //sends messages in a round robin way to all the actors
            roundRobinRouter.tell(i);
            if (i == 5) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("\n");
            }
        }
        _system.shutdown();
    }
}
