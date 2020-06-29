package com.aixuexi.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 分表测试启动类
 *
 * @author xf.chen
 * @date 2020/6/29 11:21
 * @since 1.2.0
 */
@SpringBootApplication
@MapperScan("com.aixuexi.sharding.mapper")
public class ShardingBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ShardingBootstrap.class);
    }
}
