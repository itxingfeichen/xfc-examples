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
    +   zk中的三种角色，leader/follower/observer[zk中的三种角色](https://www.jianshu.com/p/fe6f807735b4)  [zk中的三种角色](https://blog.csdn.net/yu757371316/article/details/80742223)
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
        +   相关api操作见@See ZKJavaApi
    +   zookeeper的权限acl
        +   schema:授权对象
        +   ip：
        +   Digest：username：password
        +   world：开发式的权限控制模式，数据节点的访问权限对所有用户开放
        +   super：超级用户，可以对zookeeper上的数据节点进行操作
    +   zookeeper中的连接状态
        @Deprecated
        Unknown (-1)
        Disconnected (0)
        @Deprecated
        NoSyncConnected (1)：未连接
        SyncConnected (3)：已异步连接
        AuthFailed (4)：认证失败
        ConnectedReadOnly (5)：连接只读
        SaslAuthenticated(6)：通过SASL认证
        Expired (-112)：连接（会话）已过期
    +   节点触发类型
        None (-1)：客户端和服务端连接状态发生变化的时候，事件类型就是None
        NodeCreated (1)：节点被创建
        NodeDeleted (2)：节点被删除
        NodeDataChanged (3)：节点被修改
        NodeChildrenChanged (4)：子节点被修改
    +   zkClient的使用
    +   Curator的使用
        +   介绍：curator是由Netflix公司开源的zookeeper客户端，curator对zookeeper的各种使用场景进行了封装。curator-framework提供了fluent风格的api，curator-replice提供了实现封装
        +   重试策略
            +   ExponebtialBackoffRetey()衰减重试
            +   RetryNtimes指定最大重试次数
            +   RetryOneTIme 仅仅重试一次
            +   RetryUnitilElapsed 一直重试，直到规定事件
        +   事务操作@See CuratorFrameworkTransactionDemo
        +   事件操作（三种watcher来做的节点监听）
            +   pathCache 监视一个路径下子节点的创建，删除，更新
            +   NodeCache 监听一个节点的创建，更新，删除
            +   TreeCache pachcache+nodecache合体（监视路径下的创建，更新，删除事件）
            +   缓存路径下的所有子节点的数据
    +   zk的应用场景
        +   订阅发布(watcher机制)
            +   统一配置管理
                +   zookeeper使用的是推拉相结合的方式 ，客户端向服务端注册自己需要关注的节点，一旦数据发生变化，服务端会通过watcher通知到客户端，之后客户端主动去服务端进行拉取数据更新
                +   特点
                    +   数据量小
                    +   数据内容在程序运行时动态更新
                    +   集群中的各个机器共享配置
           分布式锁
            +   redis可以实现
            +   zk实现（通过节点特性），临时节点的特性
                +   共享锁
                    ![通过zookeeper临时有序节点实现分布式锁的原理](./images/通过zookeeper临时有序节点实现分布式锁的原理.jpg '通过zookeeper临时有序节点实现分布式锁的原理')
                +   排他锁
                    
            +   数据库
                +   通过创建一个表，增加唯一索引，所有节点访问某个资源时。都去这个表insert一条数据，insert成功代表获取到锁。否则获取失败。获取到锁的节点操作结束后需要进行删除该记录
        +   负载均衡
            + 请求分发到各个不同的计算机单元
        +   id生成器
        +   分布式队列
        +   统一命名服务
        +   master选举
    +   zookeeper总结
        +   数据模型
            +   数据模型是一个树形结构，最小数据单元是znode，每个节点可以存储少量数据
            +   临时节点（有序/无序），
                +   依据这些特性可以做发布订阅，负载均衡，统一命名，集群，配置中心 。。。
                +   客户端连接服务端的会话结束，该节点就会被清理
            +   持久化节点（有序/无序）
                +   依据这些特性可以做发布订阅，负载均衡，统一命名，集群，配置中心 。。。
            +   特性
                +   原子型：要么同时成功，要么同时失败（分布式事务）
                +   单一视图：无论客户端连接到哪个服务器，看到的模型都是一致的
                +   可靠性：通过zab协议的崩溃恢复和原子广播。可以保证数据的一致行和可靠性，一旦服务器提交了一个事务并且获得了服务器端返回成功的表示，那么这个事务锁引起的服务器端的变更会一直保留
                +   实时行：近实时（节点之间的数据同步非常高）
            +   zookeeper并不是用来存储数据的（主要用于监控数据状态变化，以达到基于数据的集群管理，能在分布式架构中可以做到数据的同步，状态的控制等）
        +   集群配置（机器数量为2n+1台）
            +   修改zoo.cfg
                +   server.id=ip:port:port,ip:port:port
                +   第一个port是数据同步通信的端口，第二个port是用于leader选举的端口
                +   server.id=id
                +   myid文件（myid参与leader的选举），内容：server.id对应的就是当前机服务器的id号    
            +   如果增加observer
                +   需要在第一步中增加server.id=ip:port,ip:port:observer;peerType=observer
        +   会话
            +   NOT_CONNECT-->CONNECTION-->CONNECTED-->CONNECT_CLOSE
            +   如果一个客户端提交了一个事务到follower节点，follower节点是不能直接处理事务请求的，需要进行转发到leader节点
        +   Watcher
            +   EventType
                +   NONE：客户端与服务器端成功建立会话
                +   NodeCreated：节点创建（子节点创建才会触发）
                +   NodeDeleted：节点删除（子节点删除才会出发）
                +   NodeDataChanged：数据变更
                +   NodeChildrenChanged：子节点发生变更，子节点删除，新增的时候才会出发
            +   特性：事件被处理一次后，会被移除，如果需要永久监听，则需要反复注册
        +   ACL权限操作：保证存储在zookeeper上的数据安全问题
            +   schema（ip/djgest/world/wuper）
            +   授权对象（ip，root：root/world：anyone/admin）
        +   数据存储
            +   内存数据和磁盘数据
                +   内存数据（zookeeper底层是key-value方式存储），ConcurrentHashMap<String,DataNode>
                    +   zookeeper会定时同步到磁盘上（时间间隔可以通过zoo.cfg配置同步策略）
                    +   dataDir目录存储的是数据快照
                +   磁盘数据
                    ![zookeeper数据存储快照](./images/zookeeper数据储存快照.jpg 'zookeeper数据存储快照')
                +   zookeeper的日志
                    +   zookeeper.out ： zookeeper运行日志
                    +   事务日志
                    +   快照：存储某一时刻的全量数据  
##  Dubbo 
+   dubbo是什么：dubbo是一个分布式的高性能的服务框架，提供高性能以及透明化的RPC远程服务调用方法，以及SOA服务治理方案
+   dubbo核心部分：远程通信，服务治理，负载均衡
+   dubbo的服务检查
    +   dubbo:reference check属性，默认值为true，指启动时会强制检查依赖的服务是否有效，否则启动失败
    +   dubbo:consumer check属性，默认值为true，指启动时会强制检查依赖的服务是否有效，否则启动失败
    +   dubbo:registry  check属性  check=true ,指注册订阅失败报错
+   dubbo的多协议支持
    +   dubbo支持的协议：dubbo,hessian,rmi,webservice,thrift,http
##   Netty(需补课)
##  ActiveMQ
*   概念：java消息服务是java平台中关于面向消息中间件的API，用与在两个应用程序之间，或者分布式系统中发送消息，进行异步通信，jms是一个具体平台无关的API，绝大多数MOM（message oriented Middleware）(面向消息中间件提供商都对jms提供了支持)
*   应用场景
    +   消息异步
    +   应用解耦
    +   流量削锋  
*   消息传递域
    +   点对点
        +   每个消费者只能有一个消费者
        +   消息的生产者和消费者之间没有时间上的相关性，无论消费者在生产者发送消息的时候是否处于运行状态，都可以提取
    +   发布订阅
        +   每个消息可以有多个消费者
        +   消息的生产者和消费者席间存在时间上的相关性，订阅一个主题的消费者只能消费来自它订阅之后发的消息。JMS允许提供客户端创建持久消息
    +   JMS的API
        +   ConnectionFactory
        +   Session
        +   Destination
        +   MessageProducer/MessageConsumer
    +   JMS的可靠性机制
        +   jms消息发送之后被确认，才会认为是消费成功，消息的消费包含三个阶段，客户端接收消息，客户端处理消息，消息被客户端进行确认
        +   事务性会话（第一个参数为true是则默认是事务性会话）
            +   connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            +   消费端调用commit方法代表所有消息都自动确认接收到
        +   非事务性回话connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            +   取决于第一个参数为false，第二个参数可进行配置 
            +   static final int AUTO_ACKNOWLEDGE = 1;
                +   当客户端成功从receive方法返回以后，或者MessageListener的onMessage方法获取到消息后会进行自动确认
            +   static final int CLIENT_ACKNOWLEDGE = 2;
                +   客户端确认，客户端可以通过textMessage.acknowledge()方法进行确认消息。在这种模式下，如果一共是10个消息，那么如果消费了5个消息，然后在地5个消息后进行了textMessage.acknowkedge()方法，则之前消费的5个消息都会被确认，后面的5个则不会被消费 
            +   static final int DUPS_OK_ACKNOWLEDGE = 3;
                +   延迟确认
            +   static final int SESSION_TRANSACTED = 0;
        +   本地事务
            +   
        +   jms的（pub/sub）模型
            +   订阅可以分为持久订阅和非持久订阅
            +   当所有的消息必须接受的时候，则可以考虑使用持久订阅，反之，则用非持久订阅
        +   jms的（p2p点对点模型）
            +   如果session关闭时，有一些消息已经收到牡丹石还没有签收，那么当消费者再次连接到相同的队列时，消息还会被签收
            +   如果用户在receive方法中设定了消息选择条件，那么不符合条件的消息会留在队列中不会被消费
            +   队列可以长久保存消息，直到消息被消费者签收，消费者不需要担心因为消息丢失而要不要去时刻连接provider端
        +   Broker：可以理解为一个服务，可以进行自定义broker
            +   
        +   activeMQ的消息发送策略
            +   持久化消息
                +   默认情况下，生产者发送的消息是持久化的，消息发送到broker后，producer会等待broker对这条消息的处理情况的反馈
                    为了提高持久化消息的发送新能，可以设置消息发送端发送持久化消息的异步方式
                    可以通过activeMqConnectionFactory类的方setUseAsyncSend(true)来完成异步发送。
                    +   异步发送消息会产生的问题：如果是异步发送，因为队列的容量是有限的，如果异步发送的化，客户端可能不能立即知道当前已经不能发送消息。
                        解决办法：通过connectionFactory.setProducerWindowSize()设置回执窗口大小。当这个回执窗口被填满了，则会立即反馈个客户端不能发送消息
            +   非持久化消息
                +   设置方法：connectionFactory.setJMSDeliveryMode(DeliverMode.NON_PERSISTENT)
                +   持久化消息模式下，默认就是异步发送过程，如果需要对持久化消息的每次发送的消息获得broker的回执，可通过如下设置完成connectionFactory.setAlwaysSyncSend()
            +   consumer获取消息是pull还是（broker主动推送的）
                +   默认情况下，mq服务器采用异步方式向客户端主动推送消息（push）。也就是说broker在某个消费者会话推送消息后，不会等待消费者响应消息，知道消费者处理完成后，主动给服务端反馈信息
                    参数：prefectchsize
                +   预取消息数量
                    +   broker端一旦有消息，就主动按照默认设置的规则推送给当前活动的消费者，每次推送都有一定的数量限制，而这个数量就是prefectchSize
            +   关于acknowledge为什么能够在第n次消费消息，主动ack后，会把前面的消息都消费掉
                +   activemq会记录当前客户端已消费的数据数，deliveredMessages参数保存了客户端当前消费了但是没有确认的数据集合，在确认时，会将已消费到到数据都进行确认掉
            +   spring整合activemq
            +   activemq支持的传输协议
                +   TCP
                +   UDP
                +   NIO（基于tcp）
                +   SSL（基于tcp）
                +   HTTP(S)（基于tcp）
                +   VM（基于tcp）
                +   协议的配置方法，在rabbtimq的配置文件activemq.xml文件增加transportConnector标签即可，使用时传入对应协议的url即可
                    !['activemq协议配置图'](./images/mq协议配置图.PNG 'mq协议配置图')
                +   ActiveMq的持久化存储["activemq的持久化"](http://activemq.apache.org/persistence.html '持久化)
                    !['activemq持久化存储'](./images/mq数据持久化方式.PNG 'activemq持久化存储')
                    +   kahaDB
                    +   ampPersistence
                    +   jdbc
                        !['activemq通过jdbc持久化存储'](./images/activemq的jdbc配置方法.PNG 'activemq通过jdbc持久化存储')
                        +   需要在activemq.xml中配置数据源
                            !['需要在activemq.xml中配置数据源'](./images/数据源配置.jpg '需要在activemq.xml中配置数据源')
                        +   将数据员通过jdbcPersistenceAdapter标签配置
                            !['jdbcPersistenceAdapter标签配置'](./images/通过mysql持久化消息配置.jpg 'jdbcPersistenceAdapter标签配置')
                        +   自动建表
                            !['自动建表'](./images/activemq自动创建的表.jpg '自动建表')
            +   activemq的网络连接
                +   静态网络
                    !['activeMq配置静态网络原理'](./images/activemq的静态网络.jpg 'activeMq配置静态网络原理')
                    +   容错协议的配置：一个消费者可以连接多个服务端，如果当前消费者正在消费的broker宕机，可以立即去其他broker继续消费，因为消息会进行回流
                    +   network配置静态网络            
                        ["network配置静态网络"](http://activemq.apache.org/networks-of-brokers 'network配置静态网络)
                    +   <networkConnectors>
                        +    <networkConnector uri="static:(tcp://host1:61616,tcp://host2:61616,tcp://..)"/>
                    +   </networkConnectors>
                +   动态网络连接
            +   activemq和zookeeper实现高可用架构 
## kafka["kafka官网"](http://kafka.apache.org/quickstart 'kafka官网)
*   概念
*   安装
    +   kafka配置
        !['配置本机id以及ip'](./images/kafka基础配置.jpg '监听消息')
        !['配置zookeeper'](./images/kafka配置zookeeper.jpg '监听消息')
    +   解压 tar  -vxf kafkaxxx.tgz
    +   配置 conf/server.properties的id参数
    +   配置 listeners
    +   配置 zookeeper地址    
*  基本操作          
    +   启动服务 sh kafka-server-start.sh ../config/zookeeper.properties
    +   创建队列 sh kafka-topics.sh --create --bootstrap-server ip:9092 --replication-factor 1 --partitions 1 --topic test
    +   发送消息 sh kafka-console-producer.sh --broker-list ip:9092 --topic test
        !['发送消息'](./images/kafka命令发送消息.jpg '发送消息')
    +   消费消息 sh kafka-console-consumer.sh --bootstrap-server ip:9092 --topic test --from-beginning
        !['监听消息'](./images/kafka监听消息.jpg '监听消息')
+   实现细节
    +   存储可靠性   --partitions    代表分片数参数代表副本数（保证消息的吞吐量）
    +   发送可靠性   --replication-factor    参数代表副本数（各个机器相互备份其他机器的内容达到消息可靠性） 
        +   副本消息也有leader和follower的方式维护 
        !['发送可靠性和存储可靠性'](./images/kafka消息的高可用和高性能配置参数.jpg '监听消息')
    +   Partition规则
    +   ISR（副本同步队列），满足存储到ISR队列需要满足两个条件
        +   副本同步细节
            !['kafka副本同步细节'](./images/kafka副本同步细节.jpg 'kafka副本同步细节')
        +   副本的所有节点都需要跟zookeeper保持连接状态
        +   副本的最后一条消息的offset和leader副本的最后一条消息的offset之间的差值不能超过指定阀值，该阀值是可以进行设置的。一旦ISR队列中的某个节点与zookeeper断开联系，则会被踢出ISR队列
+   kafka的分区分片策略
    +   range策略
    +   inbalance策略
## redis
*   redis的特点
    *   redis数据类型
        +   字符类型
        +   散列类型
        +   列表类型
        +   集合类型
        +   有序集合
    *   功能
        +   可以为每个key设置超时时间
        +   可以通过列表类型数据做分布式队列
        +   支持发布订阅
    *   简单
        +   使用简单，提供非常多的交互命令
*   redis的应用场景
    +   数据缓存（热点数据，商品数据）
    +   单点登录
    +   应用模块开发
    +   网站访问排名
*   redis基本操作
    !['redis基本操作'](./images/redis基本操作.jpg 'redis基本操作')
*   redis的数据支持
    +   redis默认支持16个数据库
    +   不支持自定义数据库名称
    +   16个数据库之间并不是完全隔离，flushall可以清空所有数据库的数据
    +   不支持对单个数据库进行权限的定义
*   各种数据类型的使用
    +   字符类型（默认一个字符类型的key为512M）
        +   set key value
        +   get key
*   redis的持久化机制
    +   RDB：按照规则定时将数据同步到磁盘
        +   快照方式
            +   配置自己的快照规则
                +   save <secondes> <changes>  代表在多少秒内更新了多少数据时会触发快照
            +   save或者bgsave
                +   save:执行内存的数据同步到磁盘的操作，这个操作会阻塞客户端的请求
                +   bgsave:在后台异步执行快照操作，这个操作不会阻塞客户端的请求
            +   执行flushall
            +   执行复制的时候
        +   快照的执行原理：redis会使用fork函数复制一份当前进程的副本（子进程），fork进程负责把内存的数据同步到磁盘的临时文件，父进程继续处理客户端请求
    +   AOF：每次执行完命令后，把命令本身记录下来（是随着用户的操作同步进行将命令追加到磁盘文件，因此会有性能上的问题，这就是aof的缺点）
        +   修改redis.conf中appendonly=yes开启aof持久化方式，重启后执行对数据的变更，则会在bin目录下生成对应的aof文件，aof会记录所有的操作命令
            通过auto-aof-rewrite-
    +   两种持久化策略可以同时使用，也可以使用其中一种，如果同时使用的话，redis重启，会优先通过aop文件还原数据
    +   同步到磁盘
        +   redis每次更改数据的时候，sof机制会讲命令记录到aof文件，但是由于操作系统的缓存机制，数据并没有实时写入到磁盘，而是进入磁盘缓存，而是进入磁盘去刷新保存到文件。redis提供了如下三种方式
            +   appendsync always 每次执行写入都会进行同步，这个是最安全倒是最低效
            +   appendsync everysec 每一秒同步一次（默认）
            +   appendsync no 不主动同步，由操作系统去执行，这个最快，但是不安全
    +   aof文件损坏以后如何修复
        +   通过redis-check-aof-fix命令可以进行修复
*   reds集群方式
    +   主从模式
        +   修改redis.conf的slave of masterip master port
    +   哨兵模式
*   redis的优缺点
    +   优点
        +   可以最大化redis的性能
    +   缺点
        +   可能会存在数据丢失的请求
        
      
      
---------------------
快照的实现原理
    1：redis使用fork函数复制一份当前进程的副本(子进程)
    2：父进程继续接收并处理客户端发来的命令，而子进程开始将内存中的数据写入硬盘中的临时文件
    3：当子进程写入完所有数据后会用该临时文件替换旧的RDB文件，至此，一次快照操作完成。  
     注意：redis在进行快照的过程中不会修改RDB文件，只有快照结束后才会将旧的文件替换成新的，也就是说任何时候RDB文件都是完整的。 这就使得我们可以通过定时备份RDB文件来实现redis数据库的备份， RDB文件是经过压缩的二进制文件，占用的空间会小于内存中的数据，更加利于传输。
    RDB的优缺点
    1.	使用RDB方式实现持久化，一旦Redis异常退出，就会丢失最后一次快照以后更改的所有数据。这个时候我们就需要根据具体的应用场景，通过组合设置自动快照条件的方式来将可能发生的数据损失控制在能够接受范围。如果数据相对来说比较重要，希望将损失降到最小，则可以使用AOF方式进行持久化
    2.	RDB可以最大化Redis的性能：父进程在保存RDB文件时唯一要做的就是fork出一个子进程，然后这个子进程就会处理接下来的所有保存工作，父进程无序执行任何磁盘I/O操作。同时这个也是一个缺点，如果数据集比较大的时候，fork可以能比较耗时，造成服务器在一段时间内停止处理客户端的请求；
    实践
        修改redis.conf中的appendonly yes ; 重启后执行对数据的变更命令， 会在bin目录下生成对应的.aof文件， aof文件中会记录所有的操作命令
        如下两个参数可以去对aof文件做优化
        auto-aof-rewrite-percentage 100  表示当前aof文件大小超过上一次aof文件大小的百分之多少的时候会进行重写。如果之前没有重写过，以启动时aof文件大小为准
        auto-aof-rewrite-min-size 64mb   限制允许重写最小aof文件大小，也就是文件大小小于64mb的时候，不需要进行优化
        AOF
        AOF可以将Redis执行的每一条写命令追加到硬盘文件中，这一过程显然会降低Redis的性能，但大部分情况下这个影响是能够接受的，另外使用较快的硬盘可以提高AOF的性能
    实践
        默认情况下Redis没有开启AOF（append only file）方式的持久化，可以通过appendonly参数启用，在redis.conf中找到 appendonly yes
        开启AOF持久化后每执行一条会更改Redis中的数据的命令后，Redis就会将该命令写入硬盘中的AOF文件。AOF文件的保存位置和RDB文件的位置相同，都是通过dir参数设置的，默认的文件名是apendonly.aof. 可以在redis.conf中的属性 appendfilename appendonlyh.aof修改
        aof重写的原理
        Redis 可以在 AOF 文件体积变得过大时，自动地在后台对 AOF 进行重写： 重写后的新 AOF 文件包含了恢复当前数据集所需的最小命令集合。 整个重写操作是绝对安全的，因为 Redis 在创建新 AOF 文件的过程中，会继续将命令追加到现有的 AOF 文件里面，即使重写过程中发生停机，现有的 AOF 文件也不会丢失。 而一旦新 AOF 文件创建完毕，Redis 就会从旧 AOF 文件切换到新 AOF 文件，并开始对新 AOF 文件进行追加操作。AOF 文件有序地保存了对数据库执行的所有写入操作， 这些写入操作以 Redis 协议的格式保存， 因此 AOF 文件的内容非常容易被人读懂， 对文件进行分析（parse）也很轻松
    同步磁盘数据
        redis每次更改数据的时候， aof机制都会讲命令记录到aof文件，但是实际上由于操作系统的缓存机制，数据并没有实时写入到硬盘，而是进入硬盘缓存。再通过硬盘缓存机制去刷新到保存到文件
        # appendfsync always  每次执行写入都会进行同步  ， 这个是最安全但是是效率比较低的方式
        appendfsync everysec   每一秒执行
        # appendfsync no  不主动进行同步操作，由操作系统去执行，这个是最快但是最不安全的方式
        aof文件损坏以后如何修复  
        服务器可能在程序正在对 AOF 文件进行写入时停机， 如果停机造成了 AOF 文件出错（corrupt）， 那么 Redis 在重启时会拒绝载入这个 AOF 文件， 从而确保数据的一致性不会被破坏。
        当发生这种情况时， 可以用以下方法来修复出错的 AOF 文件：
        1.	为现有的 AOF 文件创建一个备份。
        2.	使用 Redis 附带的 redis-check-aof 程序，对原来的 AOF 文件进行修复。
        redis-check-aof --fix
        重启 Redis 服务器，等待服务器载入修复后的 AOF 文件，并进行数据恢复。
        RDB 和 AOF ,如何选择
        一般来说,如果对数据的安全性要求非常高的话，应该同时使用两种持久化功能。如果可以承受数分钟以内的数据丢失，那么可以只使用 RDB 持久化。有很多用户都只使用 AOF 持久化， 但并不推荐这种方式： 因为定时生成 RDB 快照（snapshot）非常便于进行数据库备份， 并且 RDB 恢复数据集的速度也要比 AOF 恢复的速度要快 。
        两种持久化策略可以同时使用，也可以使用其中一种。如果同时使用的话， 那么Redis重启时，会优先使用AOF文件来还原数据

集群
    复制（master、slave）
        配置过程
        修改11.140和11.141的redis.conf文件，增加slaveof masterip masterport
        slaveof 192.168.11.138 6379
        实现原理
        1.	slave第一次或者重连到master上以后，会向master发送一个SYNC的命令
        2.	master收到SYNC的时候，会做两件事
        a)	执行bgsave（rdb的快照文件）
        b)	master会把新收到的修改命令存入到缓冲区
        缺点 没有办法对master进行动态选举
        复制的方式
        1.	基于rdb文件的复制（第一次连接或者重连的时候）
        2.	无硬盘复制
        3.	增量复制
        PSYNC master run id. offset
    哨兵机制
        sentinel
        1.	监控master和salve是否正常运行
        2.	如果master出现故障，那么会把其中一台salve数据升级为master
        集群（redis3.0以后的功能）
        根据key的hash值取模 服务器的数量 。 
        hash
    集群的原理
        Redis Cluster中，Sharding采用slot(槽)的概念，一共分成16384个槽，这有点儿类似前面讲的pre sharding思路。对于每个进入Redis的键值对，根据key进行散列，分配到这16384个slot中的某一个中。使用的hash算法也比较简单，就是CRC16后16384取模。Redis集群中的每个node(节点)负责分摊这16384个slot中的一部分，也就是说，每个slot都对应一个node负责处理。当动态添加或减少node节点时，需要将16384个槽做个再分配，槽中的键值也要迁移。当然，这一过程，在目前实现中，还处于半自动状态，需要人工介入。Redis集群，要保证16384个槽对应的node都正常工作，如果某个node发生故障，那它负责的slots也就失效，整个集群将不能工作。为了增加集群的可访问性，官方推荐的方案是将node配置成主从结构，即一个master主节点，挂n个slave从节点。这时，如果主节点失效，Redis Cluster会根据选举算法从slave节点中选择一个上升为主节点，整个集群继续对外提供服务。这非常类似服务器节点通过Sentinel监控架构成主从结构，只是Redis Cluster本身提供了故障转移容错的能力。
        slot（槽）的概念，在redis集群中一共会有16384个槽，
        根据key 的CRC16算法，得到的结果再对16384进行取模。 假如有3个节点
        node1  0 5460
        node2  5461 10922
        node3  10923 16383
        节点新增
        node4  0-1364,5461-6826,10923-12287
        删除节点
        先将节点的数据移动到其他节点上，然后才能执行删除
    市面上提供了集群方案
        1.	redis shardding   而且jedis客户端就支持shardding操作  SharddingJedis ； 增加和减少节点的问题； pre shardding
        3台虚拟机 redis 。但是我部署了9个节点 。每一台部署3个redis增加cpu的利用率
        9台虚拟机单独拆分到9台服务器
        2.	codis基于redis2.8.13分支开发了一个codis-server
        3.	twemproxy  twitter提供的开源解决方案
##  nginxn原理
*   nginx的动态代理
    +   正向代理
    +   反向代理
        +   ip代理
        +   端口代理
        +   域名代理
*   location的匹配规则
    +   精准匹配
    +   普通匹配
        +   如果存在多个前缀相同路径，会按照最长前缀进行匹配
            +   location /prefix/
            +   location /prefix/xx/yyy   这个会被匹配到
    +   正则匹配
    +   优先级  精准匹配>普通匹配>正则匹配
*   rewrite的使用
    +   支持url跳转，if判断，return
    +   作用域：server/location/if，只能对域名后面的除参数外的字符串起作用
    +   语法 if(条件){}
*   缓存配置
*   压缩 gzip

##  分库分表
*   为什么要分库分表
    +   性能问题
    +   容量问题
*   如何解决
    +   垂直切分
        +   垂直分表：解决但表列过多的问题
            +   er分表：相互有联系的表存储到一个表
        +   垂直分库：解决表过多的问题
    +   水平切分：大数据表拆成小表
        +   一致性hash
        +   范围切分
        +   日期拆分
    +   拆分带来的问题
        +   跨库join
            +   可以通过提供接口的方式解决
            +   全局表（公共服务）
            +   字段冗余（空间换时间）（如果数据变化，可以mq异步通知）
        +   跨分片数据排序分页
            +   应用层拼接（查询查询两个系统的数据进行拼接）
            +   UUID
            +   zookeeper
            +   mongodb
    *   mycat
        +   mycat的核心概念
            +   逻辑库
##  mongodb
*   集群
*   分片
        
        
     
             
                
                
     

    
             
                   
                    
    
    


















    
