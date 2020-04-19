package com.github.xfc.proxy.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  20:59
 * @description: cglib代理类
 */
public class CglibQueryServiceProxy implements MethodInterceptor {


    /**
     * 获取一个代理对象
     *
     * @return
     */
    public Object getProxy(Object object) {
        Enhancer enhancer = new Enhancer();
        // 类似与jdk代理，设置生成哪个类的子类代理
        enhancer.setSuperclass(object.getClass());
        // 设置回调当前方法的intercept方法
        enhancer.setCallback(this);
        // 第一步，生成源码
        // 第二步，编译成class文件
        // 第三步，加载到jvm
        return enhancer.create();
    }


    /**
     * 代理对象（被代理对象的子类）
     *
     * @param o           这个对象是cglib 通过反射给我们创建的被代理对象的子类对象
     * @param method      代理类的方法
     * @param objects     代理类的参数
     * @param methodProxy 方法代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行方法:" + method.getName());
        System.out.println("cglib执行方法之前");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib执行方法之后。。。");
        return invoke;
    }
}
