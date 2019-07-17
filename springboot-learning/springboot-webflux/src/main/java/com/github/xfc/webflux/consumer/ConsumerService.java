package com.github.xfc.webflux.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author : chenxingfei
 * @date: 2019/7/17  14:16
 * @description: 消费者服务
 */
@Component
public class ConsumerService {

    @RabbitListener(queues = "someQueue")
    public void processMessage(Message content, Channel channel) throws IOException {
        channel.basicAck(content.getMessageProperties().getDeliveryTag(), false);
        System.out.println(content.toString());
    }
}
