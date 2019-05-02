#  分布式基础
##  什么是分布式
##  分布式和集群的关系
### 分布式
*   指一个业务拆分成多个子系统，部署在不同的服务器
### 集群
*   指同一个业务部署在多个服务器上，保证服务高可用

### Session共享问题解决方案
*   session stricky(保证同一个请求地址请求到同一台服务器)
*   session replication
*   session集中存储（db，redis）
*   cookie（userId+token+timestamp）

##  分布式通信协议介绍
### 网络协议TCP/IP和UDP/IP
*   TCP/IP
    +   TCP五层模型：应用层，传输层，链路层，网络层，物理层
    +   OSI七层模型：应用层，传输层，链路层，网络层，物理层，表达层，绘画层
    +   TCP滑动窗口
*   TCP的三次握手和四次挥手
    +   三次握手
    +   四次挥手
*   BIO/NIO

##  分布式通信协议-序列化
*   什么是序列化和反序列化
    +   序列化：把对象转化为字节序列的过程称为序列化
        +   注意点：序列化不保存静态变量的状态 @See UserTest.testStaticVariable()
        +   如果父类没有序列化，子类序列化了，则在序列化是，父类的属性会无法序列化（但是不糊报错）
    +   反序列化：把字节序列转化为对象的过程称为反序列化
    +   序列号的作用：能够保证序列化好反序列化的是同一个对象，如果序列化和反序列化的版本好不一致则会报错
    +   序列化的存储规则：如果对同一个对象进行多次序列化，序列化文件的大小不是翻倍，而是只会在序列化文件中多增加一个引用（这个引用的大小是5个字节）
*   @Transient:忽略序列化@See UserTest.testSerializable()
*   序列化保存方式：可以存储到硬盘或内存
*   java的序列化机制，需要实现Serializable接口
*   java的序列化存在的问题
    +   序列化数据结果比较大，传输效率比较低
    +   不能跨语言对接
*   通过序列化实现克隆（深克隆，浅克隆）todo
    +   深克隆：通过序列化和反序列化实现
    +   浅克隆:实现Cloneable接口，调用clone方法即可
*   目前主流的序列化
    +   JSON/hession/xml/protobuf/kryo/msgpack/fst/thrift/protostuff
    +   Protobuf非常适合网络传输，因为序列化后的字节数小,效率高
*   总结
    +   在java中，只要一个类实现了java.io.Serializable接口，那么它就可以被序列化
    +   通过ObjectOutputStream和ObjectInputStream对对象进行序列化和反序列化
    +   对象是否允许被反序列化，不仅仅是取决于对象的代码是否一直，同时还有一个重要的因素就是serializableVersionUID
    +   序列化不保存静态变量
    +   要想父类对象也参与序列化操作，需要父类也实现java.io.Seriabliable接口
    +   Transient关键字，主要控制变量是否能够被序列化，如果没有被序列化的成功变量反序列化后，会被设置为初始值
    +   通过序列化方式实现深度克隆
##  分布式通信协议值http协议
*   客户端---->服务端
*   资源
    +   html/文本，媒体
*   媒体类型
    +   Mime类型,text/html,image/jpeg
*   url和uri
    +   uri：web服务器资源的名字。
*   请求方法：get/post/put/delete/patch
*   状态码说明
    +   1xx：提示信息
    +   2xx：成功信息
    +   3xx：重定向
    +   4xx：客户端错误
    +   5xx：服务端错误
*   http协议的特点
    +   无状态：指http请求之间没有任何依赖关系，完全独立
    +   多次请求
    +   基于tcp协议
*   https
    +   概念：http加密协议，加密方式ssl（security socket layer）/tls
    +   https工作原理
        +   加密的问题
            +  
        +   密钥是公开的，所有的客户端都可以拿到
        +   针对不同的客户端使用不同的密钥
        +   使用非对称加密
            1.	服务器端把公钥发送给每一个客户端
            2.	服务器端把公钥放到远程服务器，客户端可以请求到
            3.	让浏览器保存所有的公钥（不现实）
        +   公钥被调包的问题按照上面的方案，永远存在。
        +   使用第三方机构来解决
            +   通过第三方机构，使用第三方机构的私钥对我们【需要传输的公钥】进行加密
        +   数字证书包含的内容
            +   公司信息，网站信息等
            +   每个客户端都会维护一个受信任的证书列表
-----------------
![客户端和服务端证书授权过程](./images/http协议授权原理.png '授权过程说明')

*   RestFul的最佳设计
    +   域名:http://api.rd.com
    +   版本：http://api.rd.com/v1
    +   路径：http://api.rd.com/v1/users-list,http://api.rd.com/v1/user/1
    +   过滤信息：http://api.rd.com/v1/users-list?age=10
    +   状态码
        +   业务状态码
        +   http状态码
*   总结
    +   分布式架构的定义和分布式架构的演进、
    +   分布式架构和集群的区别
    +   TCP/UDP。全双工，半双工，单通信，3次握手，四次挥手
        +   三次握手
            +   客户端发送一个序列号到服务端，确认客户端要链接服务端
            +   服务端对序列号进行加一进行返回给客户端，告诉客户端可以链接
            +   客户端向服务端确认已经收到ack，并开始建立链接
        +   四次挥手
            +   客户端发送FIN标示的报文给到server端
            +   服务端接收到FIN标示后，标示客户端没有数据要发送给服务端了
            +   服务端生成一个随机Ack号给到客户端，服务端Time_wait后关闭链接
            +   客户端接收到服务端接收到Ack的报文，表示服务端没有数据要发送给服务端了。客户端Time_wait后关闭链接
    +   http和https协议，restful规范
        +   客户端发起一个https请求
            +   客户端支持的加密方式
            +   客户端生成的随机数（第一个随机数）
        +   服务端收到请求后
            +   返回证书，或者提示客户端下载证书。
            +   生成一个随机数，返回给客户端（第二个随机数）
        +   客户端拿到证书后开始进行验证
            +   根据办法机构找到本地的根证书
            +   根据ca得到根证书，通过公钥对数字签名解密，得到证书的内容摘要
            +   用证书提供的算法对证书内容解密，获取到摘要内容
            +   通过前两步的对比，也就是验证数字签名
        +   验证通过后，生成一个随机数（第三个随机数），通过证书内的公钥对这个随机数进行加密，发送给服务端
        +   （随机数1+2+3）通过对称加密得到一个密钥（会话密钥）
        +   通过会话密钥对内容进行对称加密传输
        
##  分布式通信框架rmi(现在用得较少了)
*   什么是rmi
*   RPC协议，其实是一个规范。dubbo,thrift,rmi,webservice,hessain
*   特点
    +   网络协议和网络IO对于调用端和服务点来说透明
    +   没有重试机制
    +   基于BIO（同步阻塞io），因此效率低
    +   jdk自带的分布式通信协议
    +   不可跨语言
*   自己做rpc应该包含的要素
    +   客户端
        +  RPC proxy
        + message protocol
        +  Transfer -tcp/udp ..
    +   服务端
        +  processor
        +  message protocol
        +  Transfer -tcp/udp ...
*  如何实现一个RMI程序
    *   第一步：创建远程接口，并切集成java.rmi.Remote接口
    *   实现远程接口，并集成UnicastRemoteObject
    *   创建服务器程序，LocateRegistry.createRegistry注册服务并绑定端口
    *   通过Naming.bind("rmi://localhost:8888/test/rmi",rmiService);设置请求路由和端口
    *   编写客户端程序，通过Naming.lookup("rmi://localhost:8888/test/rmi")获取请求端服务接口，然后调用指定方法。这就完成了rmi程序的远程调用
*   自己实现rmi程序的步骤（数据都需要序列化才能进行网络传输）
    *   编写服务器程序，暴露一个监听，可以使用socket
    *   编写客户端程序，通过ip和端口链接到指定的服务器，并将数据进行封装（序列化）
    *   服务端接收到数据后进行数据的反序列化，返回在将数据序列化后返回，这就完成了自己的rmi服务
*   rmi通信原理图
--------------------------------------------------------
![rmi通信原理图](./images/rmi通信原理图.png 'rmi通信原理图')
![rmi通信时序图](./images/rmi通信时序图.png 'rmi通信时序图')

##  分布式通信框架-webservice
*   什么是webService
    *   也可以叫做xml web service
    *   跨平台
*   为什么要使用webservice
    *   跨语言调用的解决方案
*   为什么要使用webservice
*   webservice中的一些概念
    *   wsdl（web service definition language）:webservice 通过wsdl文件说明自己对外提供了哪些接口，接口对应的参数，方法等。该文件是基于xml文件进行定义的
        *   一个webservice服务对应一个wsdl文件
        *   定义了web service的服务端和客户端交互的数据请求格式和数据响应格式和方式
    *   Soap（simple object access protocol简单对象访问协议）
        *   webservice通过http发送的请求内容（请求报文）和响应内容（响应报文）都是xml格式的数据
    *   SEL（web service endpoint interface）:webservice 终端接口
    
*   开发一个webservice实例
    *   生成webservice客户端的依赖文件命令： wsimport -keep http://localhost:8888/webservice/test?wsdl
*   分析wsdl文档接口
*   webservice的wsdl文件（服务端发布代码见xfc-distributed-webservice-server项目、）
![webservice的wsdl文件](./images/webservice的wsdl文件.jpg 'webservice的wsdl文件')
------------
*   根据wsdl生成的客户端java文件调用方式
![根据wsdl生成的客户端java文件调用方式](./images/根据wsdl生成的客户端java文件调用方式.jpg 'webservice的wsdl文件')

##  分布式协调服务-zookeeper
*   分布式环境的特点
    +   分布性
    +   并发性：程序并行过程中，并发性操作非常多，比如同一个分布式系统中的多个节点，同时访问一个共享资源。数据库，分布式存储
    +   无序性：进程之间的消息通信，会出现顺序不一致问题
*   分布式网络面临的问题
    +   通信问题：网络本身的不可靠性
    +   网络分区（脑裂）：分布式架构中的部分节点失效，导致节点之间延时增大，慢慢拖垮系统。数据同步问题等
*   三态
    +   成功
    +   失败
    +   超时
*   分布式事务（ACID）
    +   todo
*   中心化和去中心化（[中心化和去中心化](https://www.jianshu.com/p/70af20eac0be)）
    +   中心化：在一个分布有众多节点的系统中，每个节点都具有高度自治的特征。节点之间彼此可以自由连接，形成新的连接单元。任何一个节点都可能成为阶段性的中心，但不具备强制性的中心控制功能。节点与节点之间的影响，会通过网络而形成非线性因果关系。这种开放式、扁平化、平等性的系统现象或结构，我们称之为去中心化
        +   
    +   去中心化：随着主体对客体相互作用的深入和认知机能的不断平衡、认知结构的不断完善，个体能从自我中心状态中解除出来，称之为去中心化
        +   
*   经典的CAP和BASE理论
    *   CAP
        +   C（consistency）：一致性，所有节点上的数据，时刻保持一致
        +   A（availability）：系统可用性，每个请求都能够收到一个响应，无论响应成功或者失败
        +   P（Partition-tolerance）：表示系统出现脑裂以后，可能导致某些server以集群中的其他机器失去联系
        +   CA
        +   CP
        +   说明：CAP理论仅仅适用于原子读写NoSQl场景，不适用于数据库系统
    *   BASE
        +   基于CAP理论，CAP理论并不适用于数据库事务（因为更新一些错误数据而导致数据库数据紊乱，无论什么样的数据库高可用方案都是徒劳）。虽然XA事务可以保证数据库在分布式系统下的ACID特性，但是会带来性能方面的影响
        +   ebay尝试了完全不同的方式，放宽了对事务ACID的要求，提出了BASE理论
        +   Basically available(基本可用):数据库分片，如某些数据库节点被破坏，但是其他节点还会能正常服务于其他用户。影响面只会设计部分用户
        +   soft-state：允许数据状态短时间只能不同步（比如支付回调，允许短时间只能不同步）
        +   Eventually consistent:数据最终一致性
*   初步认识zookeeper
    +   概念：是一个分布式协调服务，是有雅虎创建的，基于google chubby。分布式数据一致性解决方案
    +   zookeeper能做什么：数据的发布/订阅（配置中心：disconf），通过zk负载均衡，命名服务，master选举（kafka，hadoop，hbase），分布式队列，分布式锁
    +   zk特性
        +   顺序一致性：从同一个客户端发起的事务请求，最终会严格按照顺序被应用到zookeeper中
        +   原子性：所有的事务请求的处理结果在整个集群中的所有机器上的应用是一致的，也就是说整个集群中的所有机器都成功应用了某一个事务
        +   可靠性：一旦服务器成功应用了某一个事务数据，并且对客户端做了响应，那么这个数据在整个集群中一定是同步并且保留下来的
        +   实时性：一旦一个事务被成功应用，客户端 就能立即从服务器读取到事务变更后的最新数据状态；（仅仅保证在一定时间内，近实时） 
    +   zk中的三种角色，leader/follower/observer[zk中的三种角色](https://www.jianshu.com/p/fe6f807735b4)
        +   leader：Leader作为整个Zookeeper集群的主节点，负责响应所有对Zookeeper状态变更的请求。它会将每个状态更新请求进行排序和编号，以便保证整个集群内部消息处理的FIFO
        +   follower：除了响应本服务器上的读请求外，Follower还要处理Leader的提议，并在Leader提交该提议时在本地也进行提交。Follower处理提议的过程已经在ZAB协议中描述过了
        +   observer：如果Zookeeper集群的读取负载很高，或者客户端多到跨机房，可以设置一些observer服务器，以提高读取的吞吐量,observer节点可以避免水平扩展follower节点时所有节点同步数据带来的网络开销，因为新增的节点可以直接想observer节点同步数据，observer节点会同步leader的所有数据。Observer和Follower比较相似，只有一些小区别：首先observer不属于法定人数，即不参加选举也不响应提议；<br>
                      其次是observer不需要将事务持久化到磁盘，一旦observer被重启，需要从leader重新同步整个名字空间
    +   客户端的写操作一定会请求到leader节点，而客户端的读操作会根据算法分配到不同的节点    
    +   集群节点中，只要有超过一般的额机器成功，则会直接响应客户端成功，但是基于zk的原子性，如果其他机器没有成功的化，在没有成功的节点会去跟leader进行数据同步
    +   zk的选举算法，如果leader宕机，所有的子节点(不包含observer节点)会开始进行选举（这个过程会带来一定的网络延迟）
    +   zk配置文件分析
        +   tickTime:表示zk中的基础事件单位长度，单位是毫秒
        +   initLimit：leader等待follower节点同步数据的时间
        +   syncLimit:leader和follower心跳检测的最大时间
        +   dataDir：zookeeper运行数据的快照存储位置
        +   clientPort：客户端连接服务端的请求端口
    +   zk中的数据模型：zk中的数据模型和文件系统类似，每一个节点称为znode，是zo中的最小数据单元，每一个znode上都可以保存数据和挂载子节点，从而构成一个层次化的属性结构
    +   zk中的节点的特性
        +   持久化节点：节点创建后hi一直存在zk服务器上，知道主动删除
        +   持久化有序节点：每个节点都会为它的一级子节点维护一个顺序
        +   临时节点：临时节点的生命周期和客户端的会话会保持一直，当客户端会话失效，该节点会自动清理
        +   临时有序节点：在临时节点上多了一个顺序特性
    +   会话的概念：指的是客户端连接zk服务端的状态变化
        ![会话状态](./images/会话状态.png '会话状态')
    +   Watcher
        +   zookeeper提供了分布式数据发布/订阅,zookeeper允许客户端向服务器注册一个watcher监听。当服务器端的节点触发指定事件的时候<br>
            会触发watcher。服务端会向客户端发送一个事件通知 watcher的通知是一次性，一旦触发一次通知后，该watcher就失效
    +   ACL
        +   zookeeper提供控制节点访问权限的功能，用于有效的保证zookeeper中数据的安全性。避免误操作而导致系统出现重大事故。<br>
            CREATE /READ/WRITE/DELETE/ADMIN
    +   zk的命令操作
        +   增加节点：create [-s][-e] path [acl]
            +   -s表示是否为有序节点
            +   -e表示是否为临时节点
            ![增加节点](./images/增加节点.jpg '增加节点')
        +   删除节点:delete path [version]
        +   修改节点:set path data [version]
            修改节点 path对应的data
            乐观锁的概念
            数据库里面有一个 version 字段去控制数据行的版本号
        +   获取节点:get path [watcher]
            ![获取节点信息](./images/获取节点信息.jpg '获取节点信息')
    +   STAT说明（节点信息说明）
        +   cversion = 0       子节点的版本号
        +   aclVersion = 0     表示acl的版本号，修改节点权限
        +   dataVersion = 1    表示的是当前节点数据的版本号
        +   ctime = Sat Aug 05 20:48:26 CST 2017
        +   mtime = Sat Aug 05 20:48:50 CST 2017
        +   cZxid = 0x500000015 节点被创建时的事务ID
        +   ctime = Sat Aug 05 20:48:26 CST 2017
        +   mZxid = 0x500000016 节点最后一次被更新的事务ID
        +   mtime = Sat Aug 05 20:48:50 CST 2017
        +   pZxid = 0x500000015 当前节点下的子节点最后一次被修改时的事务ID
        +   dataVersion = 1
        +   aclVersion = 0
        +   ephemeralOwner = 0x0   创建临时节点的时候，会有一个sessionId 。 该值存储的就是这个sessionid
        +   dataLength = 3    数据值长度
        +   numChildren = 0  子节点数
    +   zookeeper的javaAPI
        +   原生api基础连接方法
            ![原生api基础连接方法](./images/zookeeper原生api连接基础代码.jpg '原生api基础连接方法')

        
    
    


















    
