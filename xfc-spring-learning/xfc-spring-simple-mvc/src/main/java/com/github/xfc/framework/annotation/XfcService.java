package com.github.xfc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:35
 * @description: service注解
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface XfcService {

    String value() default "";
}
