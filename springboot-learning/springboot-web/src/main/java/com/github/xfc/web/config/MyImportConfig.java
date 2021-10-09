package com.github.xfc.web.config;

import com.github.xfc.web.annotation.MyAnnotation;
import com.github.xfc.web.annotation.MyAnnotation1;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;

/**
 * import测试
 *
 * @author xf.chen
 * @date 2021/9/15 10:21
 * @since 1.0.0
 */
@MyAnnotation
@Configuration
public class MyImportConfig implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ConfigurableEnvironment environment;

    @MyAnnotation1
    @Autowired(required = false)
    private List<MyServerProperties> myServerProperties;


    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("myServerProperties = " + myServerProperties);
        System.out.println(environment.getProperty("aaa"));

        final ConfigurableEnvironment bean = applicationContext.getBean(ConfigurableEnvironment.class);


    }

    public static void main(String[] args) {
        try {
            Thread.sleep(30000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
