package com.github.xfc.distributed.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author : chenxingfei
 * @date: 2019-04-30  21:58
 * @description: 客户端
 */
public class Client {


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            OutputStream outputStream = socket.getOutputStream();

            PrintWriter printWriter = new PrintWriter(outputStream, true);

            printWriter.write("服务端你好");
            socket.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
