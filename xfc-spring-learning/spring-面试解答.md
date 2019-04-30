# Spring面试总结
##  SpringAop动态代理有哪些实现方式？
*   JDO Proxy
*   Cglib
##  SpringMvc的父子容器是什么？
*   Spring中所有容器都首先需要实现BeanFactory，如IOC容器，AOP容器，MVC容器
##  Spring中哪些类时单例的
*   Spring BeanFactory记载配置时，只要没有配置Scope=Single的都默认时单例
##  SpringBean什么时候被垃圾回收
*   Spring运行的时候实际上都是普通的java类（包括代理以后的类，都要被ClassLoad加载），如果对象的引用被设置为nul，则会被垃圾回收
##  

     