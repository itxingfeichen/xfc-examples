package com.xfc.structure.statck;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jannik
 * @version v1.0.0
 * @description 链表模拟栈
 * @date 2019-12-14 13:29
 **/
public class LinkedStack implements Stack {

    /**
     * 初始化头节点
     */
    private final Node head;

    private Node last;

    /**
     * 初始化链表大小
     */
    private final int maxSize;

    public LinkedStack(int maxSize) {
        this.head = new Node(-1, null);
        this.maxSize = maxSize;
        this.last = head;
    }

    /**
     * 是否栈满
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return size() >= maxSize;
    }

    /**
     * 是否栈空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 压栈
     *
     * @param value
     */
    @Override
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("已栈满");
        }
        Node newNode = new Node(value, null);
        last.next = newNode;
        this.last = newNode;
    }

    /**
     * 出栈
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Node temp = head;
        while (temp.next != last) {
            temp = temp.next;
        }
        int value = last.data;
        // 删除最后一个元素
        temp.next = null;
        return value;
    }

    /**
     * 遍历
     */
    @Override
    public void list() {
        Node temp = head;
        while (temp.next != null){
            System.out.println("节点["+temp.next+"]");
            temp = temp.next;
        }
    }


    /**
     * 获取元素个数
     *
     * @return
     */
    @Override
    public int size() {

        if (head.next != null) {
            Node temp = head;
            int count = 0;
            while (temp.next != null) {
                temp = temp.next;
                count++;
                System.out.println("temp = " + temp);
            }
            return count;
        }
        return 0;
    }

    /**
     * 链表节点
     */
    @Data
    @AllArgsConstructor
    private static class Node {

        /**
         * 节点数据
         */
        private int data;

        /**
         * 下一个节点
         */
        private Node next;
    }


}
