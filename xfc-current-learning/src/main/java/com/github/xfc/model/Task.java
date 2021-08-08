package com.github.xfc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : chenxingfei
 * @date: 2019-04-02  22:01
 * @description: 任务类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Comparable, Runnable {

    /**
     * 任务id
     */
    private Long id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务属性
     */
    private String attribute;

    @Override
    public int compareTo(Object o) {
        Task target = (Task) o;
        return -Long.compare(this.id, target.getId());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((new Date())+"当前线程" + Thread.currentThread().getName() + " 当前任务id=" + this.id + " 当前任务名称=" + name);
    }
}
