
#   多线程并发知识了解
## 通过wait方法和notify模拟队列的阻塞

## 线程池的使用
* submit方法和execute方法的区别
   * submit可以传入实现Callable接口的实例对象
   * submit方法有返回值，返回一个Future
   * execute无返回值，因此submit接口功能比execute强大

## junit多线程测试问题

## CountDownLatch与CycleBarrier
* CountDownLatch属于一个线程等待多个线程执行完成
* CycleBarrier属于多个线程同时启动，只要有一个线程未准备好都不会运行
    
## Future和Callable
* Future模式可以非常合适的再处理很耗时的业务逻辑使用，可以有效的见效系统的响应时间，提高系统吞吐量
    
##  原子性，可见性，有序性理解
*   原子性：原子性是指一个线程的操作是不能被其他线程打断，同一时间只有一个线程对一个变量进行操作。在多线程情况下，每个线程的执行结果不受其他线程的干扰。
*   可见性：可见性是指一个线程修改的共享变量，其他线程可以立即知道该线程修改后的新值。但是不具有原子性，因为在一个线程修改后，可能有多个线程同时获取到修改后的变量，然后多个变量再去修改就会覆盖数据，修改为旧值
*   有序性：我们都知道程序是按代码顺序执行的，对于单线程来说确实是如此，但在多线程情况下就不是如此了。为了优化程序执行和提高CPU的处理性能，JVM和操作系统都会对指令进行重排，也就说前面的代码并不一定都会在后面的代码前面执行，即后面的代码可能会插到前面的代码之前执行，只要不影响当前线程的执行结果。所以，指令重排只会保证当前线程执行结果一致，但指令重排后势必会影响多线程的执行结果
        
## 信号量
*  非常适合高并发访问
    * 相关概念
        *  PV：页面的访问次数，网站的总访问量或点击量，用户每刷新一次就会被记录一次
        *  UV：访问网站的客户端数，按照ip进行统计，统一ip每天只记录一次
        *  QPS：每秒查询次数，qps很大程度上代表的是系统的繁忙程度。每次请求的背后都会有多次磁盘io，多次的网络请求，多个cpu时间片。通过qps可以直观了解到当前系统的情况。一旦QPS超过设定的阀值，则可以考虑进行扩容，一面压力过大
        *  RT：请求的响应时间，说明当前的用户体验
        
## 秒杀系统
## master-worker模式
## 锁
*   在多线程中，我们知道可以通过synchronized关键字来实现线程之间的同步互斥工作，那么其实还有个更优秀的机制去完成"同步互斥"工作，他就是Lock对象
*   Lock对象的两种实现
    *   ReentrantLock（重入锁）
        *   本质跟synchronized差不多，只是使用方法上需要手动释放锁
        *   配合Condition使用，并且可以使用多个Condition
        *   公平锁或非公平锁
        *   相关方法
            *   tryLock() 尝试获取锁
            *   isFair(）是否为公平锁
            *   getHoldCount() 获取当前lock的次数
            *   其他方法
    *   ReentrantReadWriteLock：读写分离的锁
        *   重入锁说明，已经获得锁的线程去访问一个需要相同锁的方法，不需要再次获得锁。因此叫做可重入锁
        *   分ReadLock，WriteLock读写锁，根据ReentrantReadWriteLock实例的readLock()方法和writeLock()方法可以获取读写锁
        *   在高并发情况下，对于读多写少的情况下，性能远高于ReentrantLock
        *   读写锁的原理：本质分为读锁和写锁，读锁可以支持多线程并行读取，而写是必须一个一个线程进行读写，所以性能要好于ReentrantLock
        *   口诀：读读共享，写写互斥，读写互斥
    *   锁的优化总结
        *   避免死锁 
        *   减小锁的持有时间
        *   减小锁的粒度 
        *   锁的分离
        *   尽量使用无锁的操作，如原子操作（Atomic系列类），volatile关键字
    *   分布式锁
    *   信号量，回环栏栅，CountDownLatch
        *   Semaphore(信号量)：
        *   CyclicBarrier(回环栏栅)：线程间阻塞，必须等待所有的线程完成任务，然后一起释放线程
            *   含两个构造器new CyclicBarrier(Integer count),new CyclicBarrier(Integer count,Runnable runnable)
                *   count:代表需要阻塞的线程个数
                *   Runnable:所有任务完成后，额外需要进行的操作任务
        *   CountDownLatch(计数)：
## 并发框架Distruptor
*   disruptor术语说明
    *   RingBuffer: 被看作是Disruptor最重要的组件，然而从3.0开始RingBuffer仅仅负责存储和更新在Disruptor中数据的流通
    *   Sequence: Disruptor使用Sequence来表示一个特殊组件处理的序号。和Disruptor一样，每个消费者（EventProcessor）都维持着一个Sequence大部分的并发代码依赖Sequence值运转，因此Sequence支持多种当前为AtomicLong类的类型
    *   Sequencer: 这是Disruptor真正的核心。实现了这个接口的两种生产者（单生产者和多生产者）均实现了所有的并发算法，为了在生产者和消费者之间进行准确快速的数据传递
    *   SequenceBarrier: 由Sequencer生成，并且包含了已经发布的Sequence的引用，这些Sequence源于Sequencer和一些独立的消费者的引用。它包含了决定是否由供消费者来消费的的Event的逻辑
    *   WaitStrategy: 决定消费者将如何顶戴生产者将Event置入Disruptor
    *   Event: 从生产者到消费者过程中所处理的数据单元。Disruptor中没有代码表示Event，因为这是用户自定义的    
    *   EventProcessor：主要事件循环，处理Disruptor中的Event，并且拥有消费者的Sequence。他有一个实现类是BatchEventProcessor，包含了event loop有效的实现，并可将回调到一个EventHandler接口的实现对象。
    *   EventHandler：由用户实现并且代表了Disruptor中的一个消费者的接口
    *   Producer：由用户实现，它调用RingBuffer来插入事件（Event），在Disruptor中没有相应的代码实现，它是由用户实现的
    *   WorkProcessor：确保每个Sequence只被一个processor消费，在同一个WorkPool中处理多个WorkProcessor不会消费同样的Sequence
    *   WorkPool：一个WorkProcessor池，其中WorkProcessor将消费Sequence，所以任务可以在实现WorkHandler接口的Worker之间移交
    *   LifecycleAware：当BatchEventProcessor启动和停止时，于实现这个接口用于接收通知
*   Disruptor相对于传统方式的优点：
    *   没有竞争=没有锁=非常快。
    *   所有访问者都记录自己的序号的实现方式，允许多个生产者与多个消费者共享相同的数据结构。
    *   在每个对象中都能跟踪序列号（ring buffer，claim Strategy，生产者和消费者），加上神奇的cache line padding，就意味着没有为伪共享和非预期的竞争。
*   CAS算法（Compare And Swap）
*   