package com.github.xfc.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:35
 * @description: controller注解
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface XfcResponseBody {


    String value() default "";
}
