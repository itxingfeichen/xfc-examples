package com.xfc.distributed.activemq.top.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  12:37
 * @description: 简单生产者（点对点）
 */
public class TopProducer {

    public static void main(String[] args) throws JMSException {

        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://192.168.22.128:61617");

        Connection connection = activeMQConnectionFactory.createConnection();

        connection.start();


        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        // 创建队列
        Topic queue = session.createTopic("queue-topic");

        // 创建生产者
        MessageProducer producer = session.createProducer(queue);
        // 构造消息体
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("hello activemq-----top");

        // 发送消息
        producer.send(textMessage);


        session.commit();
        session.close();
        connection.close();
    }
}
