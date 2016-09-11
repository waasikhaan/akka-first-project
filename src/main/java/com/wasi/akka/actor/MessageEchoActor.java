package com.wasi.akka.actor;

import akka.actor.UntypedActor;

/**
 * Created by wasikhan on 5/16/2016.
 */
public class MessageEchoActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
            System.out.println("Message: " + o);
    }
}
