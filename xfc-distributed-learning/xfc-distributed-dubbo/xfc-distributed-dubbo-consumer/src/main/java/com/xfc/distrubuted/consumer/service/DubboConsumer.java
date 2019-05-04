package com.xfc.distrubuted.consumer.service;

import com.xfc.distributed.dubbo.api.IDubboTestService;
import com.xfc.distributed.dubbo.common.RequestDto;
import com.xfc.distributed.dubbo.common.ResponseDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:16
 * @description:
 */
public class DubboConsumer {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/dubbo-consumer.xml");
        IDubboTestService dubboTest = (IDubboTestService) context.getBean("demoService");
        RequestDto requestDto = new RequestDto();
        requestDto.setOrderId(11L);
        requestDto.setOrderNo(UUID.randomUUID().toString());
        ResponseDto responseDto = dubboTest.helloDubbo(requestDto);
        System.out.println("requestDto = " + responseDto);

    }
}
