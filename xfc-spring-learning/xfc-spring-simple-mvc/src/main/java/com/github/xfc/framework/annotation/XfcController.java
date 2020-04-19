package com.github.xfc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:35
 * @description: controller注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface XfcController {

    String value() default "";
}
