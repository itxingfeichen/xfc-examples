package com.xfc.distributed.activemq.broker.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : cxf
 * @date: 2019/5/11  16:40
 * @description: 给予自定义broker的producer
 **/
public class CustomBrokerProducer {


    public static void main(String[] args) throws JMSException {

        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:16162");

        Connection connection = activeMQConnectionFactory.createConnection();

        connection.start();


//        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        // 需要消费者通过textMessage.acknowledge()方法进行消息确认
        Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);

        // 创建队列
        Queue queue = session.createQueue("dimple-queue");

        // 创建生产者
        MessageProducer producer = session.createProducer(queue);
        // 构造消息体
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("自定义的broker");

        // 发送消息
        producer.send(textMessage);


//        session.commit();
        session.close();
        connection.close();
    }
}
