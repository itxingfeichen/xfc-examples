package com.github.xfc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:35
 * @description: controller注解
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface XfcRequestMapping {

    String value() default "";
}
