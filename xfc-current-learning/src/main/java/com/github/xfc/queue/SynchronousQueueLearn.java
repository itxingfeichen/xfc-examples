package com.github.xfc.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author : chenxingfei
 * @date: 2019-04-03  23:11
 * @description: 同步队列学习
 * <p>
 * 特点：
 * 1、不能在同步队列上进行 peek，因为仅在试图要取得元素时，该元素才存在；
 * 2、除非另一个线程试图移除某个元素，否则也不能（使用任何方法）添加元素;也不能迭代队列，因为其中没有元素可用于迭代。队列的头是尝试添加到队列中的首个已排队线程元素； 如果没有已排队线程，则不添加元素并且头为 null。
 * 3、对于其他 Collection 方法（例如 contains），SynchronousQueue 作为一个空集合。此队列不允许 null 元素。
 * 4、它非常适合于传递性设计，在这种设计中，在一个线程中运行的对象要将某些信息、事件或任务传递给在另一个线程中运行的对象，它就必须与该对象同步。
 * 5、对于正在等待的生产者和使用者线程而言，此类支持可选的公平排序策略。默认情况下不保证这种排序。 但是，使用公平设置为 true 所构造的队列可保证线程以 FIFO 的顺序进行访问。 公平通常会降低吞吐量，但是可以减小可变性并避免得不到服务。
 * 6、SynchronousQueue的以下方法：
 * * iterator() 永远返回空，因为里面没东西。
 * * peek() 永远返回null。
 * * put() 往queue放进去一个element以后就一直wait直到有其他thread进来把这个element取走。
 * * offer() 往queue里放一个element后立即返回，如果碰巧这个element被另一个thread取走了，offer方法返回true，认为offer成功；否则返回false。
 * * offer(2000, TimeUnit.SECONDS) 往queue里放一个element但是等待指定的时间后才返回，返回的逻辑和offer()方法一样。
 * * take() 取出并且remove掉queue里的element（认为是在queue里的。。。），取不到东西他会一直等。
 * * poll() 取出并且remove掉queue里的element（认为是在queue里的。。。），只有到碰巧另外一个线程正在往queue里offer数据或者put数据的时候，该方法才会取到东西。否则立即返回null。
 * * poll(2000, TimeUnit.SECONDS) 等待指定的时间然后取出并且remove掉queue里的element,其实就是再等其他的thread来往里塞。
 * * isEmpty()永远是true。
 * * remainingCapacity() 永远是0。
 * * remove()和removeAll() 永远是false。
 * <p>
 * SynchronousQueue 内部没有容量，但是由于一个插入操作总是对应一个移除操作，反过来同样需要满足。那么一个元素就不会再SynchronousQueue 里面长时间停留，
 * 一旦有了插入线程和移除线程，元素很快就从插入线程移交给移除线程。也就是说这更像是一种信道（管道），资源从一个方向快速传递到另一方 向。显然这是一种快速传递元素的方式，
 * 也就是说在这种情况下元素总是以最快的方式从插入着（生产者）传递给移除着（消费者），这在多任务队列中是最快处理任务的方式。在线程池里的一个典型应用是Executors.
 * newCachedThreadPool()就使用了SynchronousQueue，这个线程池根据需要（新任务到来时）创建新的线程，如果有空闲线程则会重复使用，线程空闲了60秒后会被回收。
 */
public class SynchronousQueueLearn {

    /**
     * 声明同步队列
     */
    private static final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

    /**
     * put元素
     *
     * @param ele
     */
    public void put(String ele) {
        try {
            synchronousQueue.put(ele);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取元素
     */
    public String take() {
        try {
            return synchronousQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
