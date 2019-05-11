package com.xfc.distributed.activemq.simple.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  12:37
 * @description: 简单生产者
 */
public class SimpleProducer {

    public static void main(String[] args) throws JMSException {

        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://192.168.22.128:61617");

        Connection connection = activeMQConnectionFactory.createConnection();

        connection.start();


        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        // 创建队列
        Queue queue = session.createQueue("dimple-queue");

        // 创建生产者
        MessageProducer producer = session.createProducer(queue);
        // 构造消息体
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("hello activemq");

        // 发送消息
        producer.send(textMessage);


        session.commit();
        session.close();
        connection.close();
    }
}
