package com.github.xfc.nio;

import java.io.IOException;

/**
 * @author : chenxingfei
 * @date: 2019-05-03  23:18
 * @description: 模拟nio客户端
 */
public class CClient {

    public static void main(String[] args) throws IOException {
        new NioClient().start("Nike-C");
    }
}
