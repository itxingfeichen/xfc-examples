package com.xfc.distributed.activemq.spring.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-05-11  20:11
 * @description:
 */
public class AmqProducerServiceTest {

    ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-jms.xml");
    }


    @Test
    public void testSendMessage() {

        AmqProducerService amqProducerService = (AmqProducerService) context.getBean("amqProducerService");

        amqProducerService.sendMessage("hello xfc");

    }
}