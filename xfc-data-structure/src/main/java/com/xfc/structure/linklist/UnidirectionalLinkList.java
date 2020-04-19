package com.xfc.structure.linklist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jannik
 * @version v1.0.0
 * @description 单向链表
 * @ate 2019-12-12 07:32
 **/
public class UnidirectionalLinkList {

    // 头节点
    private Node head = new Node(null, null);
    // 尾节点
    private Node lastNode = head;

    public void add(Object data) {
        Node newNode = new Node(data, null);
        lastNode.next = newNode;
        lastNode = newNode;
    }


    public Node getHead() {
        return head;
    }

    /**
     * 链表节点
     */
    @Data
    @AllArgsConstructor
    public static class Node {
        /**
         * 当前节点的数据
         */
        private Object data;
        /**
         * 下一个节点
         */
        private Node next;

        private boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +

                    '}';
        }
    }


}
