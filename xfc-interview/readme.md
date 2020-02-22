*   类加载顺序
    *   从父到子，静态先行，静态只加载一遍
    *   静态代码块->普通代码块->构造方法
*   方法覆盖问题
    *   子类是否允许抛出比父类更大的异常？
        *   不能 ：因为子类在覆盖父类的方法时，因为父类的引用可以调用子类的方法，则会导致子类抛出的异常时父类不能处理
    *   子类的修饰符权限是否比父类更大？
        *   可以：子类的修饰符权限只能大于或等于父类，如果子类权限小于父类，将会报错
*   集合类
    *   HashMap
    *   HashSet：底层HashMap，add进去的元素为key，value固定为PRESENT ，即Object对象    
    *   ArrayList/LinkedList/Vector区别？谈谈你的理解
        *   ArrayList底层是什么？扩容机制是什么？
            *   底层为Object数组，默认容量为10，容量不够时会调用grow方法通过Arrays.copyOf进行扩容
        *   ArrayList和Vector最大的区别？
            *   两者底层数据结构一致，最大的区别是Vector是强同步的，相关方法都被synchronized进行修饰，效率较低
            *   前者扩容时是扩1.5倍，后者扩容2倍
        *   ArrayList和LinkedList最大的区别？
            *   ArrayList使用动态数组实现，LinkedList链表实现
            *   随机数据访问，ArrayList可以直接访问指定角标元素，LinkedList需要移动指针，因此ArrayList具有优势
            *   数据添加，删除，ArrayList需要移动数据，LinkedList直接连接前后指针即可，因此LinkedList具有优势
*   java8特性
    *   lambda
    *   函数式接口 @FunctionalInterface
    *   接口中可以增加方法实现default方法
    *   HashMap数据结构
*   线程
    *   五种线程状态
        *   NEW
        *   RUNNABLE
        *   BLOCKED
        *   WAITING
        *   TIME_WAITING
        *   TERMINATED
*   wait和notify
    *   虚假唤醒，多线程需要使用while判断
    *   线程间通信
*   wait和sleep区别
    *   wait等待后释放锁，sleep不会释放锁
*   synchronized
    *   一个对象如果有多个synchronized方法，某一时刻，只要一个线程去调用其中synchronized方法，其他的线程都只能等待
        锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他synchronized方法
    *   所有的静态同步方法用的也是同一把是，即Class对象