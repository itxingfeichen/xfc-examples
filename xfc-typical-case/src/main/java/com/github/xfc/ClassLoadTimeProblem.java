package com.github.xfc;

/**
 * @author : chenxingfei
 * @date: 2019-07-06  10:57
 * @description: 类加载顺序测试
 */
public class ClassLoadTimeProblem {

    /**
     * 单例
     */
    private static final ClassLoadTimeProblem classLoadTimeProblem = new ClassLoadTimeProblem();

    private ClassLoadTimeProblem() {
        System.out.println("我被初始化了。。。");
    }

    private static final Boolean BOOLEAN = true;

    /**
     * 这个变量属于ClassLoadTimeProblem的非static成员变量，但是这个变量依赖了BOOLEAN变量BOOLEAN
     * <p>
     * 根据java的类加载顺序，在初始化classLoadTimeProblem变量时就会调用构造器。此时变量BOOLEAN并没有初始化，因此test也不会被初始化。
     * <p>
     * 调用完构造器后才初始化BOOLEAN，此时test变量已经错过了加载时机，从而初始化失败
     */
    private final Boolean test = BOOLEAN;

    public Boolean getResult() {
        return test;
    }

    /**
     * 执行main打印结果是？
     *
     * @param args
     */
    public static void main(String[] args) {

        Boolean result = classLoadTimeProblem.getResult();
        if (result) {
            System.out.println("AA");
        } else {
            System.out.println("BBB");
        }


    }
}


/**
 * 本题执行结果
 * Exception in thread "main" java.lang.NullPointerException
 * at com.github.xfc.ClassLoadTimeProblem.main(ClassLoadTimeProblem.java:28)
 * <p>
 * 修改方法：将private static final Boolean BOOLEAN = true;移动到单例对象初始化之前即可，这样就能保证在单例对象初始化是调用构造器前初始化test变量
 */


