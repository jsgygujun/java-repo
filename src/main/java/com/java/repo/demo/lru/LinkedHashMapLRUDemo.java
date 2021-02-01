package com.java.repo.demo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author GuJun
 * @date 2020/12/20
 */
public class LinkedHashMapLRUDemo {

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        // 必须重写！
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return super.size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        System.out.println(cache.keySet());
        cache.put(4, "4");
        System.out.println(cache.keySet());
        cache.get(2);
        System.out.println(cache.keySet());
    }

}
