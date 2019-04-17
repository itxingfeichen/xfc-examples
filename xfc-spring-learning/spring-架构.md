# Spring架构
## Spring依赖关系图
-------
![spring5模块依赖图](./images/spring5依赖图.png 'spring模块依赖图')
##  Spring架构图
![spring架构图](./images/spring5架构图.png 'spring架构图')

##  Spring核心概念，IOC/DI
*   IOC概念
    +   IOC（Inversion of Control）控制反转：所谓控制反转，就是把原来我们代码里面需要实现的对象创建，依赖的代码，反转给容器来帮忙实现，那么必然我们需要创建一个容器，同时需要一种描述来让容器知道需要创建的对象和对象的关系。这个描述文件就是我们可配置的文件
*   DI概念
    +   DI（Dependency Injection）依赖注入：就是指对象是被动接受依赖而不是自己主动去容器中查找自己依赖的对象，换句话说就是指对象不是从容器中查找它依赖的类，而是容器在实例化对象的时候主动将它依赖的类进行注入。
* Spring的IOC体系
    +   BeanFactory：Spring Bean的创建是典型的工厂模式，这一些列的Bean工厂，也即IOC容器为开发者管理对象之间的依赖关系提供了很多便利的基础服务。在Spring中有许多的IOC容器的实现供用户选择和使用。
        +   ListAbleBeanFactory
        +   HierarchicalBeanFactory
        +   DefaultListableBeanFactory
    +   BeanDefinition:bean定义类
    +   BeanFactory与FactoryBean
        +   BeanFactory:产生Bean的工厂类,SpringIOC容器的最顶层接口，他的作用是管理Bean，即实例化，定位，配置应用程序中的对象即创建这些对象间的依赖
        +   FactoryBean:工厂生产出来的Bean，是一个Bean，作用是产生其他Bean实例。通常情况下这种Ben没有什么特殊的要求，仅仅需要提供一个工厂方法，该方法用来返回其他Bean实例，bena无须自己实现工厂模式，Spring容器担任工厂角色；少数情况下，容器中的Bean本身就是工厂，其作用是产生其他bean实例
    +   初始化
        +   资源定位（配置文件）
        +   载入（读取配置件）
        +   注册（把加载后的配置文件解释乘BeanDefinition）
*   Spring的依赖注入（DI）
    +   读取BeanDefinition中的信息，获取其依赖关系（BeanWrapper）
    +   实例化（代理，jdk代理个cglib代理）
        +   如果被代理的对象，没有实现任何接口，就是用cglib进行创建代理对象，如果实现了接口就是用jdk代理
    +   注入（为含有依赖关系的对象进行注入）
    +   IOC的两个主要方法
        +   createBeanInstance:生成bean所包含的java对象实例
        +   populateBean:对Bean属性依赖进行注入 
##  Spring的AOP
*   相关概念
    +   切面(Aspect)：官方的抽象定义为"一个关注点的模块化"，这个关注点可能会横切多个对象，就是类TestAspect所关注的具体行为
    +   连接点(JoinPoint)：程序执行过程的某一行为（是规定切面中方法的一些规则，实际是一个规则的定义）
    +   通知(Advice)："切面"对于某个"连接点"所产生的动作(一旦处罚连结点中的某个规则，就会触发一个通知（代理对象）)
        +   通知的类型
            +   前置通知：
            +   后置通知：
            +   返回后通知：
            +   环绕通知：
            +   抛出异常后通知：
    +   切入点(Pointcut)：匹配连接点的断言，在AOP中通知和一个切入点表达式关联。（进入切面内部的方法，实际上就是一个方法）
    +   目标对象(Target Object)：被一个或多个切面所通知的对象。如AService ,BService
    +   AOP代理(Aop proxy)：在Spring中的代理含两种方式，JDK动态代理和CGLib代理。默认情况下Target Object使用了JDK

##  源码分析9 已看完
    