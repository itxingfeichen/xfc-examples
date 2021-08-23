package com.github.xfc.kafka.controller;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RestController
public class ProducerController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("message/send")
    public String send(String msg) throws ExecutionException, InterruptedException {
        //使用kafka模板发送信息
        final ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaTemplate.send("demo1", msg);
        final SendResult<String, Object> sendResult = listenableFuture.get();

        return sendResult.toString();
    }
}