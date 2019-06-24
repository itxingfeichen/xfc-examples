package com.github.xfc.i18n;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : chenxingfei
 * @date: 2019-06-22  15:43
 * @description: 国际化启动类
 */
@SpringBootApplication
@MapperScan("com.github.xfc.i18n.mapper")
public class I18nApplication {

    public static void main(String[] args) {
        SpringApplication.run(I18nApplication.class);
    }
}