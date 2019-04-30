package com.github.xfc.framework.servlet;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 为了方便反射调用指定方法
 */
public class XfcHandler {

    private Object object;
    private Method method;

    private Pattern pattern;

    public XfcHandler(Object object, Method method, Pattern pattern) {
        this.object = object;
        this.method = method;
        this.pattern = pattern;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}