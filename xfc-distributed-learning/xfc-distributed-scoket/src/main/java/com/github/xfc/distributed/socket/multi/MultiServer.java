package com.github.xfc.distributed.socket.multi;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenxingfei
 * @date: 2019-04-30  21:58
 * @description: 客户端
 */
public class MultiServer {


    public static void main(String[] args) {
        try {
            InetAddress inetSocketAddress = InetAddress.getByName("224.5.6.7");
            MulticastSocket multicastSocket = new MulticastSocket();

            for (int i = 0; i < 10; i++) {
                byte[] bytes = ("Hello Client"+"i").getBytes();
                multicastSocket.send(new DatagramPacket(bytes, bytes.length, inetSocketAddress, 8888));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
