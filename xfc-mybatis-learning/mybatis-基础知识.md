# Mybatis基础知识（idea中的mybatis插件了解）
##  相关概念
##  使用方式
*   两种配置方式
    +   xml
    +   Annotation   
    
*   TypeHandle使用场景介绍
    +   定制化类型转换（比如在页面中需要展示一个枚举的多个数据值，此时则可以通过typeHandler进行转换）
*   插件（Pluging）：只可以针对某一些类做插件
    *   插件实现流程
        +   实现接口（mybatis的Interceptor接口）
            +   Interceptors注解的参数说明@Signature（type，method，args）签名，可以定义
        +   定义做plugin的目标，实现invoking方法 
        +   注册
*   Mapper文件认识
    +   namespace：用于区分各个不同的mapper文件，避免多个mapper文件中的方法重复导致mybatis在解析数据的时候会进行异常，类似与package的概念
    +   delete
    +   insert
    +   update
    +   sql代码块
    +   动态sql的拼接
*   Batch批量操作（三种）
 ---------------
 |方法|性能|影响|
 |:---:|:---:|:---:|
 |for循环单个插入|性能低，每次都需要产生sql进行操作|效率太低|
 |foreach拼接sql|性能高|sql长度有限制|
 |batchSession|性能高|执行完成后不返回主键|
*   分页
    +   逻辑分页
        +   DefaultResultSetHandler
    +   物理分页
        +   拼接sql
        +   分页插件（数据量太大会导致数据库卡死）
        +   优化点（现在因select count(0)会导致数据库查询缓慢，优化方式，计数）
*   联合查询
----------------

|类型|优势|缺点|
|:---:|:---:|:---:|
|resultType|结果清晰，便于性能调优|执行结果会产生许多的实现类|
|resultMap|不需要写join|N+1问题|
*   结果映射两种方式（两种方式类似，执行形式不同，但是在关联查询是需要定义特殊的dto）
    +   resultType
    +   resultMap
**   嵌套结果，嵌套查询
##  mybatis缓存体系
*   一级缓存
*   二级缓存
   +    需要开启才能使用
   +    在联合查询的时候会有问题（脏读）（因为联合查询出来的数据被二级缓存了，但是其他命名空间内的sql把数据更新了，这回导致数据不同步问题）
   +    数据失效问题


##  mybatis-spring整合
*   sqlSession生命周期
    +   有transaction情况下，会一直使用同一个sqlSession
    +   在无transaction情况下，每次都会新获取一个sqlSession，是request/method级别的
    
    
##  总结
*   什么是mybatis
*   mybatis和jdbc区别
*   mybatis架构图






     