package com.xfc.akka;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

/**
 * akka
 *
 * @author xf.chen
 * @date 2021/8/10 19:06
 * @since 1.0.0
 */
public class AkkaActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(String.class, msg -> {
                    System.out.println("receive msg " + msg);
                }).matchAny(msg -> {
                    System.out.println("matchAny receive msg " + msg);
                })
                .build();
    }
}
