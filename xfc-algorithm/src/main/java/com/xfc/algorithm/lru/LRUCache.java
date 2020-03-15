package com.xfc.algorithm.lru;

import lombok.Data;

import java.util.HashMap;

/**
 * least recentily using
 *
 * @author jannik
 * @date 2020-03-15
 */
public class LRUCache {

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node end;

    /**
     * 数据容器
     */
    private final HashMap<String, Node> dataMap;

    /**
     * 数据容量
     */
    private final Integer limit;

    public LRUCache(Integer limit) {
        dataMap = new HashMap(limit);
        this.limit = limit;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public synchronized void put(String key, String value) {

        Node data = dataMap.get(key);
        if (data != null) {
            data.value = value;
            refreshNode(data);
        } else {
            // 判断长度是否超出限制
            if (dataMap.size() >= limit) {
                // 删除头节点
                dataMap.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value);
            addNode(node);
            dataMap.put(key, node);
        }

    }

    /**
     * 获取缓存数据
     *
     * @param key
     * @return
     */
    public synchronized String get(String key) {

        Node node = dataMap.get(key);
        if (node == null) {
            return null;
        }
        // 刷新数据
        refreshNode(node);
        return node.value;

    }

    /**
     * 删除指定的key值
     *
     * @param key
     */
    public synchronized void remove(String key) {

        Node node = dataMap.get(key);
        if (node != null) {
            dataMap.remove(key);
            removeNode(node);
        }
    }

    private void refreshNode(Node node) {
        // 如果是尾节点则不需要变动
        if (node != end) {
            // 删除节点
            removeNode(node);
            // 新增节点
            addNode(node);

        }
    }

    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    private void removeNode(Node node) {
        if (node == head && node == end) {
            head = null;
            end = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else {
            // 中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }


}

@Data
class Node {
    Node pre;
    Node next;
    String key;
    String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
