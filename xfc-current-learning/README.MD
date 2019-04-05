
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
## 并发框架Distruptor
        
        