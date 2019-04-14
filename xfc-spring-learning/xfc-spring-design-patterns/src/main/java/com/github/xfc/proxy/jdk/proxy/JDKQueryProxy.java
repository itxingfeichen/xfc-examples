package com.github.xfc.proxy.jdk.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  14:35
 * @description: jdk数据查询代理
 */
public class JDKQueryProxy implements InvocationHandler {

    private Object object;

    public JDKQueryProxy(Object object) {
//        super();
        this.object = object;
    }

    /**
     * 代理对象
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法之前");
        Object invoke = method.invoke(object, args);
        System.out.println("hashcode"+invoke.hashCode());
        System.out.println("执行方法之后。。。");
        return invoke;
    }

    /**
     * 获取一个代理对象
     *
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }
}
