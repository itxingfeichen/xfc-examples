package com.xfc.spring.clound.config.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author : chenxingfei
 * @date: 2019-05-25  17:12
 * @description: 自定义健康检查
 */
@Component
public class MyHealthEndpoint extends AbstractHealthIndicator {
    /**
     * Actual health check logic.
     *
     * @param builder the {@link Builder} to report health status and details
     * @throws Exception any {@link Exception} that should create a {@link Status#DOWN}
     *                   system status.
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.withDetail("dbStatus","DOWN");
    }
}
