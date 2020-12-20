package com.java.repo.code.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuJun
 * @date 2020/12/20
 */
public class LRUCache {
    // 实际索引Node节点的容器
    private Map<Integer, Node> map;
    // 容量
    private final int capacity;
    // 维护一个双向队列
    // head 和 tail 本身不存储有效节点，仅作为哨兵节点
    private Node head;
    private Node tail;

    // 内部存储节点
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
        public Node() {
            prev = null;
            next = null;
        }
    }

    // 从双向链表中删除指定节点
    void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // 把指定节点加入到尾部
    void appendToTail(Node node) {
        Node prev = tail.prev;
        node.prev = prev;
        node.next = tail;
        prev.next = node;
        tail.prev = node;
    }

    // 从队首删除有效节点
    Node popFromHead() {
        Node node = head.next;
        removeNode(node);
        return node;
    }

    // 移动指定节点到队尾
    void moveToTail(Node node) {
        removeNode(node);
        appendToTail(node);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToTail(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            removeNode(node);
            Node newNode = new Node(key, value);
            appendToTail(newNode);
            map.put(key, newNode);
        } else {
            Node newNode = new Node(key, value);
            appendToTail(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                Node oldNode = popFromHead();
                map.remove(oldNode.key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
