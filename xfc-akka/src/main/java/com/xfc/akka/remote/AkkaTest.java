package com.xfc.akka.remote;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

import java.util.concurrent.TimeUnit;

/**
 * test
 *
 * @author xf.chen
 * @date 2021/8/10 19:08
 * @since 1.0.0
 */
public class AkkaTest {

    public static void main(String[] args) throws InterruptedException {
        final ActorSystem actorSystem = ActorSystem.create("YourSystem", ConfigFactory.load("yourconf"));

        final ActorRef sender = actorSystem.actorOf(Props.create(AkkaActor.class), "sender");
        sender.tell("akka test",sender);
        TimeUnit.SECONDS.sleep(1);
        actorSystem.terminate();
    }
}
