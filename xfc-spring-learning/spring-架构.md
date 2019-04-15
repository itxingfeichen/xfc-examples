# Spring架构
## Spring依赖关系图
-------
![spring5模块依赖图](./images/spring5依赖图.png 'spring模块依赖图')
##  Spring架构图
![spring架构图](./images/spring5架构图.png 'spring架构图')

##  Spring核心概念，IOC/DI
+   IOC概念
    +   IOC（Inversion of Control）控制反转：所谓控制反转，就是把原来我们代码里面需要实现的对象创建，依赖的代码，反转给容器来帮忙实现，那么必然我们需要创建一个容器，同时需要一种描述来让容器知道需要创建的对象和对象的关系。这个描述文件就是我们可配置的文件
+   DI概念
    +   DI（Dependency Injection）依赖注入：就是指对象是被动接受依赖而不是自己主动去容器中查找自己依赖的对象，换句话说就是指对象不是从容器中查找它依赖的类，而是容器在实例化对象的时候主动将它依赖的类进行注入。
+ Spring的IOC体系
    +   BeanFactory：Spring Bean的创建是典型的工厂模式，这一些列的Bean工厂，也即IOC容器为开发者管理对象之间的依赖关系提供了很多便利的基础服务。在Spring中有许多的IOC容器的实现供用户选择和使用。
    +   BeanDefinition
    
+   1:57