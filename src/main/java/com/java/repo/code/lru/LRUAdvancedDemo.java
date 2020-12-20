package com.java.repo.code.lru;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * head --> validNode-1 --> validNode-2 --> ... --> validNode-n --> tail
 * head 和 tail 不存储有效数据
 * @author GuJun
 * @date 2020/12/20
 */
public class LRUAdvancedDemo {

    public static class LRUCache<K, V> {
        private final int capacity;
        // HashMap存储Node节点
        private final Map<K, Node<K, V>> map;
        // 双向队列的头节点和尾节点
        // 这两个节点不存储实际数据
        private final Node<K, V> head;
        private final Node<K, V> tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        void put(K key, V val) {
            Node<K, V> node = map.get(key);
            if (node == null) {
                Node<K, V> newNode = new Node<>(key, val);
                map.put(key, newNode);
                appendToTail(newNode);
                if (map.size() > capacity) {
                    // 删除队首有效节点
                    Node<K, V> headNode = popHead();
                    map.remove(headNode.key);
                }
            }
        }

        // 移除节点
        void removeNode(Node<K, V> node) {
            Node<K, V> prev = node.prev;
            Node<K, V> next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        // 加入队尾
        void appendToTail(Node<K, V> node) {
            Node<K, V> validTail = tail.prev;
            node.prev = validTail;
            node.next = tail;
            validTail.next = node;
            tail.prev = node;
        }

        // 移动到头部
        void moveToHead(Node<K, V> node) {
            removeNode(node);
            appendToTail(node);
        }

        // 删除队首有效节点
        Node<K, V> popHead() {
            Node<K, V> node = head.next;
            removeNode(node);
            return node;
        }

        static class Node<K, V> {
            K key;
            V val;
            Node<K, V> prev;
            Node<K, V> next;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
                prev = null;
                next = null;
            }

            public Node() {
                this(null, null);
            }
        }
    }

    public static void main(String[] args) {
        LRUDemo.LRUCache<Integer, String> cache = new LRUDemo.LRUCache<>(2);
        cache.put(1, "1");
        cache.put(2, "2");
        System.out.println(cache.keSet());
        cache.put(3, "3");
        System.out.println(cache.keSet());
        cache.get(2);
        cache.put(4, "4");
        System.out.println(cache.keSet());
    }

}
