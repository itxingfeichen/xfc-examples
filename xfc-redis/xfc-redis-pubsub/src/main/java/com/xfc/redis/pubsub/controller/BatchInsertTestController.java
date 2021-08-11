package com.xfc.redis.pubsub.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 批量测试
 *
 * @author xf.chen
 * @date 2021/8/11 10:13
 * @since 1.0.0
 */

@RestController
public class BatchInsertTestController {


    @Value("#{${rts.store.batch.save.strategy:{1:2,2:4}}}")
    private Map<Integer, Integer> strategy;


}
