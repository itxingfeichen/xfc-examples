package com.xfc.spring.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

/**
 * @author : chenxingfei
 * @date: 2019-05-25  16:08
 * @description: config启动类
 */
@SpringBootApplication
@EnableScheduling
public class SpringCloudConfigClientApplication {

    private final ContextRefresher refresher;

    private final Environment environment;

    public SpringCloudConfigClientApplication(ContextRefresher refresher, Environment environment) {
        this.refresher = refresher;
        this.environment = environment;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class);
        System.out.println("app client start");
    }

    @Scheduled(fixedDelay = 3L, initialDelay = 1)
    public void doRefreshConfig() {
        Set<String> refresh = refresher.refresh();
//        Set<String> refreshEnvironment = refresher.refreshEnvironment();
        refresh.forEach(action -> {
            System.out.println("属性变化 = " + action + "  变化结果为=" + environment.getProperty(action));

        });

    }
}
