# Spring源码学习
##  Spring是什么（java应用框架）
*   是一个轻量级，面向Bean，松耦合，万能胶（能与主流框架无缝集成），设计模式（将java中的设计模式运用的淋漓尽致）
##  Spring设计初衷
*   Spring是为了解决企业级应用开发的复杂性而设计，他可以做很多事情，单归根结底是支撑Spring的仅仅是少许的基本理念。而所有的基本里面最终的一个根本使命就是"简化开发"
    *   Spring的四种策略
        *   基于POJO的轻量级和最小侵入性编程
        *   通过依赖注入和面向接口松耦合
        *   基于切面和惯性进行声明式编程
        *   通过切面和模版减少样板式代码
    *   她主要是通过：面向Bean，依赖注入和切面编程这三种方式来达成的
*   面向Bean编程
    *   Spring是面向Bean的编程，Bean在Spring中才是真正的主角，Bean在Spring中的作用就像Object对OOP的意义一样，Spring中如果没有Bean也就没有Spring的意义，Spring提供了IOC容器通过配置文件或注解的方式来管理对象之间的依赖关系
    *   Spring和核心概念
        *   控制反转(Inversion of Controller):控制对象的创建，最终目的是为了实现依赖注入
            *   依赖注入(Dependency inject):依赖注入
                *   @Autowired InterfaceA a;自动把它的实现类注入
                *   @Resource("beanName") InterfaceA a;IOC容器类的id对象自动注入到这里（可以支持父子类关系）
                *   @Autowired A a;可以注入普通类
            *   Spring的注入方式
                *   set方法
                *   构造方法
                *   强制赋值（暴力反射）
        *   AOP(面向切面编程):允许程序员对某个影响多个类行为的逻辑抽取出来作为一个模块嵌入到正常的业务代码中执行，可与实际业务进行松耦合。如日志管理，事物管理等。
            *   Spring中用到aop的地方
                *   Authentication 权限认证
                *   Logging 日志
                *   Transaction Manager 事务管理
                *   Lazy Loading 懒加载
                *   Context Process 上下文处理
                *   Error Handler 异常处理
                *   Cache 处理
*   常用的设计模式
    *   代理模式
        *   原理
            *   首先拿到被代理对象的引用，然后去获取它的接口
            *   JDK代理会重新生成一个类，同时实现我们给的代理对象所实现的接口
            *   把被代理对象的引用拿到
            *   重新生成一个java文件，并通过jdk自带的编译工具编译为class字节码文件
            *   通过来加载器家在到jvm
        *   适用场景
        *   原理描述
    *   工厂模式
    *   单例模式
    *   委派模式
    *   
            
        
