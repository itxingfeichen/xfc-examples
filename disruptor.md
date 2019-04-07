##  Disruptor是什么(内容参考https://www.jianshu.com/p/d24b2eb4a881)
*   disruptor是一个高性能的异步处理框架，或者可以任务是线程间通信的高效低延时内存消息组件，它的最大特点是高性能。其Lmax架构可以获得每秒6百万订单，用1微秒的延迟获得吞吐量为100K+。
*   jdk内置队列
##   实现高性能的原理   
*   Disruptor实现高性能主要体现了去掉了锁，采用CAS算法，同时内部通过环形队列实现有界队列。
*   环形数据结构
    为了避免垃圾回收，采用数组而非链表。同时，数组对处理器的缓存机制更加友好。
*   元素位置定位
    数组长度2^n，通过位运算，加快定位的速度。下标采取递增的形式。不用担心index溢出的问题。index是long类型，即使100万QPS的处理速度，也需要30万年才能用完。
*   无锁设计
    每个生产者或者消费者线程，会先申请可以操作的元素在数组中的位置，申请到之后，直接在该位置写入或者读取数据。整个过程通过原子变量CAS，保证操作的线程安全。
##  Disruptor可以做什么
*   当前业界开源组件使用Disruptor的包括Log4j2、Apache Storm等，它可以用来作为高性能的有界内存队列，基于生产者消费者模式，实现一个/多个生产者对应多个消费者。它也可以认为是观察者模式的一种实现，或者发布订阅模式。
##  为什么要使用Disruptor
*   使用Disruptor，主要用于对性能要求高、延迟低的场景，它通过“榨干”机器的性能来换取处理的高性能。如果你的项目有对性能要求高，对延迟要求低的需求，并且需要一个无锁的有界队列，来实现生产者/消费者模式，那么Disruptor是你的不二选择。
##  如何使用Disruptor
*   Disruptor 的等待策略
    /**
        //BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
        WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
        //SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
        WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
        //YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
        WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
    */


        