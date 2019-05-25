##  spring cloud
### spring clound config client
####   jdk自带的观察者模式
*   `Observerble` 发布者
*   `Observer`
####    jdk的事件/监听
*   
####    spring事件/监听
*   `ApplicationEvent`
*   `ApplicationListener`
####    springboot事件
*   `ConfigFileApplicationListener`（核心配置类）：用于管理配置文件
*   Spring控制类加载顺序的方法,通过`@Order`控制
####    spring cloud 事件/监听
*   BootstrapApplicationListener:负责加载bootstrap.properties或者application.yml

