package com.github.xfc.web.annotation;

import com.github.xfc.web.config.MyRegistrar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xingfei
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Inherited
@Qualifier
public @interface MyAnnotation1 {
}
