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

    
