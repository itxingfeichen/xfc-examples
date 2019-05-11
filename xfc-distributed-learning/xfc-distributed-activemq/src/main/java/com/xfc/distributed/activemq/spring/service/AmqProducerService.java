package com.xfc.distributed.activemq.spring.service;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  20:07
 * @description: activemq消息发送端
 */
public interface AmqProducerService {

    void sendMessage(String msg);
}
