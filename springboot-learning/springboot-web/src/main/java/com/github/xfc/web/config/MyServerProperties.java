package com.github.xfc.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xf.chen
 * @date 2021/8/24 18:22
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "myserver", ignoreUnknownFields = true)
public class MyServerProperties {

    private Integer port;


    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
