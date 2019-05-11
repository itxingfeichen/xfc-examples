package com.xfc.distributed.activemq.spring.container;

import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  20:29
 * @description:
 */
@Service(value = "destinationQueueListener")
public class ConsumerQueueListener implements MessageListener {


    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
