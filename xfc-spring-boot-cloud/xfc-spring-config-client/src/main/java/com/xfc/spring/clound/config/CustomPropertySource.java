package com.xfc.spring.clound.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-05-25  14:37
 * @description: 自定义配置，并且优先与系统类加载
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomPropertySource implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("server.port", 9090);
        MapPropertySource mapPropertySource = new MapPropertySource("my-properties-source", map);
        return mapPropertySource;
    }
}
