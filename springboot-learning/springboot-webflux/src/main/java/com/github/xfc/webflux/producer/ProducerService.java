package com.github.xfc.webflux.producer;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : chenxingfei
 * @date: 2019/7/17  14:15
 * @description: 生产者服务
 */
@Service
public class ProducerService implements RabbitTemplate.ConfirmCallback {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void testSend(){

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend("some_exchange","some_routeKey","test",correlationId);
    }

    /**
     * Confirmation callback.
     * 这里是发送成功回调
     *
     * @param correlationData correlation data for the callback.
     * @param ack             true for ack, false for nack
     * @param cause           An optional cause, for nack, when available, otherwise null.
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("correlationData = " + correlationData+" ack=" +ack);
        System.out.println("确认回调");
    }
}
