package com.github.xfc.queue;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.*;

/**
 * DelayQueue test
 */
public class ExamTest {

    public static void main(String[] args) {
        DelayQueue<Task> students = new DelayQueue<>();
        int[] time = new int[]{2000,4000,8000};
        long openTime = System.currentTimeMillis();
        //线程池
        Executor e = Executors.newFixedThreadPool(20);

        //添加一批顾客
        addTask(students,time);

        //为顾客办理业务(daemon处理业务)
        new Thread(()->{runTask(students,e);}).start();

        //下班闹钟
        new Thread(()->{openAndClose(openTime);}).start();
    }

    public static void openAndClose(long openTime) {
        while (true){
            long op = System.currentTimeMillis() - openTime;
            if(op>16000){
                System.out.println("营业时间结束，共"+op+"秒，共计"+op/3600+"小时，\n谢谢");
                System.exit(0);
            }
        }
    }

    public static void addTask(DelayQueue<Task> students,int[] time){
        final Random random = new Random();
        for(int i=0;i<20;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            students.put(new Task(new Student("顾客："+i+"号" , "办理"+(random.nextInt(3)+1)+"项业务！"),time[random.nextInt(3)]));
        }
    }

    public static void runTask(DelayQueue<Task> students,Executor exe) {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Task take = students.take();
                StringBuilder sb = new StringBuilder();
                sb.append("\n 从").append(take.getNow()).append("开始等候的，");
                sb.append("\n 到").append(take.getExpire()).append("办理结束，");
                sb.append("\n 共花了").append(take.getDelay()).append("秒，");
                sb.append("\n------------------------------");
                System.out.println("还有"+students.size()+"个人在排队...");
                Student  t = (Student) take.getT();
                t.setMsg(t.getMsg()+sb.toString());
                exe.execute(take.getT());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

@Data
class Student implements Runnable {

    private String name;
    private String msg;

    public Student(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    @Override
    public void run() {
        final StringBuilder sb = new StringBuilder("------------------------------");
        sb.append("\n服务信息：");
        sb.append("\n").append(name);
        sb.append("\n 我总共办理了" ).append(msg);
        System.out.println(sb.toString());
    }
}
@Data
class Task<T extends Runnable> implements Delayed{

    private long expire;
        private long delay;
    private long now;
    private T t;

    public Task(T t,long delay) {
        this.t = t;
        this.delay = delay;
        this.now = System.currentTimeMillis();
        this.expire = now + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(o == this){
            return  0;
        }
        if(o instanceof Task){
            return this.getDelay(TimeUnit.NANOSECONDS) > ((Task)o).getDelay(TimeUnit.NANOSECONDS) ? 1:-1;
        }
        return 0;
    }
}
