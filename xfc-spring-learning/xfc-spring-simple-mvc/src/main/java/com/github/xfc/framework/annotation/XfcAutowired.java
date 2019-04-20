package com.github.xfc.framework.annotation;

import java.lang.annotation.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  17:36
 * @description: 自动注入
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface XfcAutowired {

    String value() default "";
}
