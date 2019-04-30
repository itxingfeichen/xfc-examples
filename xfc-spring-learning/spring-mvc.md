# Spring-mvc
*   springMVC是一个框架
    *   MVC：Model,View,Controller
##  概念
##  初始化执行过程
*   加载DispatchServlet
*   默认加载IOC容器
*   开始扫描SpringMVC的配置（注解扫描，Controller，ResponseBody），插件，拦截器，转换器，视图解析器
*   解析乘HandlerMapping的List，主要保存了Url和具体的执行对象关系
##  等待用户请求（请求处理过程）
*   用户从浏览器输入url开始请求
*   统一拦截（校验是否有对应的请求路径，以及请求方式等等）
*   DispatcherServlet接收到请求，从初始化已经保存的数据中找到请求url对应的方法然后进行调用
*   输出响应结果
##  springMVC原理图
-----------
![spring-mvc原理图](./images/springmvc原理图.jpg 'springmvc原理图')
*   各个组件解释
    *   DispatcherServlet:是springmvc中的前端控制器，负责接收request并将request转发到对应的处理组件
    *   HandlerMapping:是springmvc中完成url到controller映射的组件。DispatcherServlet接收到请求，将会从请求中获取请求路径然后从HandlerMapping中查找request的controller
    *   Controller:处理request并返回ModelAndView对象，Controller是springmvc中负责处理request的组件。ModelAndView是封装结果视图的组件
    *   ModelAndView:封装视图名称，以及模型数据等
    *   ViewResolver:根据modelAndview返回的视图名称和模型数据进行解析视图
    *   View:返回解析完成的视图到客户端
*   spring-mvc初始化过程
----------
![spring-mvc初始化过程](./images/spring-mvc初始化过程.jpg 'spring-mvc初始化过程')


    