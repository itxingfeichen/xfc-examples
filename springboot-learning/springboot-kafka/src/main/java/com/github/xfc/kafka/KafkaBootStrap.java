package com.github.xfc.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * kafka整合测试类
 *
 * @author xf.chen
 * @date 2020/10/19 15:22
 * @since 1.2.0
 */
@SpringBootApplication
public class KafkaBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(KafkaBootStrap.class);
    }
}
