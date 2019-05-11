package com.xfc.distributed.activemq.spring.service.impl;

import com.xfc.distributed.activemq.spring.service.AmqProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  20:08
 * @description:
 */
@Service("amqProducerService")
public class AmqProducerServiceImpl implements AmqProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Resource(name = "destinationQueue")
    private ActiveMQQueue destinationQueue;


    @Resource(name = "destinationTopic")
    private ActiveMQTopic destinationTopic;


    @Override
    public void sendMessage(String msg) {
        // 发送点对点消息
        jmsTemplate.convertAndSend(destinationQueue,msg);
        // 发送广播
        jmsTemplate.convertAndSend(destinationTopic,"topic:"+msg);

    }
}
