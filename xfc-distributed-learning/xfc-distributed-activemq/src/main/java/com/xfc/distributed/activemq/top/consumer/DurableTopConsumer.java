package com.xfc.distributed.activemq.top.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  12:37
 * @description: 简单生产者，持久订阅，生产者推送消息以后，如果客户端已经挂了，可以保证持久订阅的客户端在恢复服务是重新可以收到top服务端推送的消息，如果不吃持久化订阅的消费者是消费不到在消费者宕机期间producer推送的消息
 */
public class DurableTopConsumer {

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.22.128:61617");


        Connection connection = null;
        Session session = null;
        try {
            connection = activeMQConnectionFactory.createConnection();
            connection.setClientID("durableID");
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }

        // 创建队列
        Topic queue = session.createTopic("queue-topic");
        TopicSubscriber subscriber = session.createDurableSubscriber(queue, "durableID");
        // 创建生产者
        TextMessage receive = (TextMessage) subscriber.receive();
        receive.acknowledge();
        System.out.println("receive.getText() = " + receive.getText());

        session.commit();
        session.close();
        connection.close();
    }
}
