package com.github.xfc.distributed.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : chenxingfei
 * @date: 2019-04-30  21:58
 * @description: 服务端
 */
public class Server {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            Socket accept = serverSocket.accept();
//
//            BufferedInputStream bufferedReader = new BufferedInputStream(accept.getInputStream());
//
//            byte[] bytes = new byte[1025];
//            bufferedReader.read(bytes,0,bytes.length);
//
//            String s = new String(bytes);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            String s = bufferedReader.readLine();
            System.out.println("接收到客户端的数据：" + s);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
