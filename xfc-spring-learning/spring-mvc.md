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


    