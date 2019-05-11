package com.xfc.distributed.activemq.broker.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : cxf
 * @date: 2019/5/11  16:40
 * @description: 给予自定义broker的producer
 **/
public class CustomBrokerConsumer {

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:16162");


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
        System.out.println("receive.getText() = " + receive.getText());

        session.commit();
        session.close();
        connection.close();
    }

}
