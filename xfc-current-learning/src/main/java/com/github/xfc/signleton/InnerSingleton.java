package com.github.xfc.signleton;

/**
 * @author : chenxingfei
 * @date: 2019-03-31  22:06
 * @description: 静态内部类方式创建饿汉式单例，也可以通过静态代码块实现，但是静态代码块的内容是在类加载结束后就会直接加载到内存，因此如果该单例在系统中一直不实用的化，会浪费内存
 */
public class InnerSingleton {

    /**
     * 私有化
     */
    private InnerSingleton() {

    }

    /**
     * 通过静态内部类创建单例对象（实际开发中常用）
     */
    private static class Singleton {
        private static final Singleton single = new Singleton();
    }

    /**
     * 获取实例对象
     * @return
     */
    public Singleton getInstance(){
        return Singleton.single;
    }

}
