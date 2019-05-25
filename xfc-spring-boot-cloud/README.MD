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

####    spring cloud配置Server中心实现
*   增加依赖
    ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
    ```
*   增加配置文件`application.yml`
    ```properties
        server:
          port: 8090
        spring:
          cloud:
            config:
              server:
                git:
                  uri: https://github.com/itxingfeichen/xfc-spring-cloud-config-repo
        #          uri: /Users/chenxingfei/WorkSpace/xfc-spring-cloud-config-repo
                  username: git账号
                  password: git密码
          application:
            name: config-server
        management:
          endpoint:
            refresh:
              enabled: false
    ```
*   配置启动类
    ```java
        @SpringBootApplication
        @EnableConfigServer
        public class SpringCloudConfigServerApplication {
            public static void main(String[] args) {
                SpringApplication.run(SpringCloudConfigServerApplication.class);
                System.out.println("app start");
            }
        }
    ```
*   访问`http://localhost:8090/my-dev.properties`检测configserver是否生效，修改git文件内容

####    spring cloud配置Client中心实现
*   增加依赖
    ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-client</artifactId>
        </dependency>
    ```
*   增加配置文件`application.yml`和`bootstrap.yml`
    *   `application.yml`
        ```properties
            server:
             port: 80
           #
           management:
             security:
               enabled: false
        ```
    *   `bootstrap.yml`
        ```properties
            spring:
              cloud:
                config:
                  ##  配置中心地址
                  uri: http://localhost:8090
                  ##  监听的配置名称 如，application-dev.yml 此处应该配置application
                  name: my-dev
                  ##  监听的文件环境 如，application-dev.yml 此处应该配置dev
                  profile: default
                  ##  监听的分之
                  label: master
              application:
                name: config-client

        ```
        
*   配置启动类
    ```java
        @SpringBootApplication
        @EnableConfigServer
        public class SpringCloudConfigServerApplication {
            public static void main(String[] args) {
                SpringApplication.run(SpringCloudConfigServerApplication.class);
                System.out.println("app start");
            }
        }
    ```
*   增加controller接口用于测试,注意需要增加`@RefreshScope`，才能刷新上下文注入的配置，如下代码中的`private String myName;`
    ```java
        /**
         * @author : chenxingfei
         * @date: 2019-05-25  19:16
         * @description: 配置服务测试
         */
        @RestController
        @RefreshScope
        public class ClientController {
        
            @Value("${my.name}")
            private String myName;
        
            @GetMapping("/myName")
            public String index(){
                return myName;
            }
        }
    
    ```
*   访问`http://localhost/myName`检测是否获取到最新的git内容
*   为了实时获取到config server 的内容，需要增加定时自动刷新配置
    ```java
    @Scheduled(fixedDelay = 3L,initialDelay = 1)
    public void doRefreshConfig(){
        Set<String> refresh = refresher.refresh();
        // Set<String> refreshEnvironment = refresher.refreshEnvironment();
        refresh.forEach(action->{
            System.out.println("属性变化 = " + action+"  变化结果为="+environment.getProperty(action));

        });

    }

    ```

