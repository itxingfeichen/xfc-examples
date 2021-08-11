package com.xfc.redis.pubsub.current;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 定时任务
 * save 900 1              #在900秒(15分钟)之后，如果至少有1个key发生变化，则dump内存快照。
 * <p>
 * save 300 10            #在300秒(5分钟)之后，如果至少有10个key发生变化，则dump内存快照。
 * <p>
 * save 60 10000        #在60秒(1分钟)之后，如果至少有10000个key发生变化，则dump内存快照。
 *
 * @author xf.chen
 * @date 2021/8/10 14:18
 * @since 1.0.0
 */
@Component
public class TimeTask implements InitializingBean, DisposableBean {

    private static final String KEY = "testBatch";


    private final RedisTemplate<String, Object> redisTemplate;

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

    private static ConcurrentLinkedQueue<String> taskQueues = new ConcurrentLinkedQueue<>();

    @Value("#{${rts.store.batch.save.strategy:{9:1,3:10,1:5}}}")
    private Map<Integer, Integer> strategy;

    public TimeTask(RedisTemplate<String, Object> redisTemplate) {

        this.redisTemplate = redisTemplate;
    }

    public void start() {

        strategy.forEach((seconds, count) -> executorService.scheduleWithFixedDelay(() -> {
            System.out.println(seconds + "：" + count + "->thread:" + Thread.currentThread().getId() + " " + new Date());
            final Long size = redisTemplate.opsForSet().size(KEY);
            if (size == null || size < count) {
                return;
            }
            final List<Object> objectList = redisTemplate.opsForSet().pop(KEY, size);
            if (CollectionUtils.isEmpty(objectList)) {
                return;
            }
            // 开始批量保存
            for (Object o : objectList) {
                System.out.print(o + " ");
            }
            System.out.println();
        }, 0, seconds, TimeUnit.SECONDS));
//        executorService.scheduleWithFixedDelay(() -> {
//            Long size = redisTemplate.opsForSet().size(KEY);
//            if (size >= 1) {
//                final List<Object> objectList = redisTemplate.opsForSet().pop(KEY, size);
//                System.out.println("size >= 1");
//                for (Object o : objectList) {
//                    System.out.print(o+" ");
//                }
//                System.out.println();
//
//            }
//        }, 0, 1, TimeUnit.SECONDS);
//        executorService.scheduleWithFixedDelay(() -> {
//            Long size = redisTemplate.opsForSet().size(KEY);
//            if (size >= 1) {
//                final List<Object> objectList = redisTemplate.opsForSet().pop(KEY, size);
//                System.out.println("size >= 5");
//                for (Object o : objectList) {
//                    System.out.print(o+" ");
//                }
//                System.out.println();
//
//            }
//
//        }, 0, 1, TimeUnit.SECONDS);
//
//        executorService.scheduleWithFixedDelay(() -> {
//            Long size = redisTemplate.opsForSet().size(KEY);
//            if (size >= 1) {
//                final List<Object> objectList = redisTemplate.opsForSet().pop(KEY, size);
//                System.out.println("size >= 10");
//                for (Object o : objectList) {
//                    System.out.print(o+" ");
//                }
//                System.out.println();
//
//
//            }
//
//        }, 0, 1, TimeUnit.SECONDS);

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        start();
        final AtomicLong atomicLong = new AtomicLong();
        final Random random = new Random();
        new Thread(() -> {
            while (true) {
                redisTemplate.opsForSet().add(KEY, atomicLong.getAndIncrement());
                try {
                    final int random1 = random.nextInt(1000);
                    TimeUnit.MILLISECONDS.sleep(random1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void destroy() throws Exception {

    }
}
