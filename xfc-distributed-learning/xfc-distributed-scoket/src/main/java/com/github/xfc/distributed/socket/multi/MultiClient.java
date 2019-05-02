package com.github.xfc.distributed.socket.multi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author : chenxingfei
 * @date: 2019-04-30  21:58
 * @description: 客户端
 */
public class MultiClient {


    public static void main(String[] args) throws IOException {
        InetAddress inetSocketAddress = InetAddress.getByName("224.225.6.7");
        MulticastSocket multicastSocket = new MulticastSocket(8888);

        multicastSocket.joinGroup(inetSocketAddress);

        byte[] bytes = new byte[1024];
        while (true){
            DatagramPacket p = new DatagramPacket(bytes, bytes.length);
            multicastSocket.receive(p);
            System.out.println(p.getData());

        }


    }
}
