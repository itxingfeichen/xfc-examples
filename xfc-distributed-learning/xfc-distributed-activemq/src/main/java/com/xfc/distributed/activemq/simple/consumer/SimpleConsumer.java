package com.xfc.distributed.activemq.simple.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  12:37
 * @description: 简单生产者（点对点）
 */
public class SimpleConsumer {

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.22.128:61617");


        Connection connection = null;
        Session session = null;
        try {
            connection = activeMQConnectionFactory.createConnection();

            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }

        // 创建队列
        Queue queue = session.createQueue("dimple-queue");

        // 创建生产者
        MessageConsumer producer = session.createConsumer(queue);
        TextMessage receive = (TextMessage) producer.receive();
        receive.acknowledge();
        System.out.println("receive.getText() = " + receive.getText() + "-=====>" + receive.getStringProperty("mykey"));

        session.commit();
        session.close();
        connection.close();
    }
}
