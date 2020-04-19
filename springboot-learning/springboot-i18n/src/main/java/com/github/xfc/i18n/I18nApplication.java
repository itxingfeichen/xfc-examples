package com.github.xfc.i18n;

import com.github.xfc.i18n.model.I18N;
import com.github.xfc.i18n.service.I18NService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

/**
 * @author : chenxingfei
 * @date: 2019-06-22  15:43
 * @description: 国际化启动类
 */
@SpringBootApplication
@MapperScan("com.github.xfc.i18n.mapper")
public class I18nApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(I18nApplication.class);

        I18N bean = context.getBean(I18N.class);
        Assert.notNull(bean, "is null????");


        I18NService nService = context.getBean(I18NService.class);
        System.out.println(nService);


    }
}
