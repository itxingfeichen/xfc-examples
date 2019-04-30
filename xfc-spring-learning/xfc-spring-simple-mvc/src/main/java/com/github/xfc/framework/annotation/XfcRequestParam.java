package com.github.xfc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:35
 * @description: controller注解
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface XfcRequestParam {

    String value() default "";

    boolean required() default false;
}
