package com.java.repo.demo.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * set: 把数据加入到map中，同时删除list中的key，然后把key加到队尾，如果超过容量，删除队首，同时删除map中的数据
 * get: 删除list中的key，把key加到队尾
 * @author GuJun
 * @date 2020/12/20
 */
public class LRUDemo {

    static class LRUCache<K, V> {
        private final int capacity;

        private final Map<K, V> map;
        private final LinkedList<K> list;

        LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<K, V>(capacity);
            list = new LinkedList<K>();
        }

        void put(K key, V value) {
            map.put(key, value);
            list.remove(key);
            list.addLast(key);
            if (list.size() > capacity) {
                K k = list.removeFirst();
                map.remove(k);
            }
        }

        V get(K key) {
            if (map.containsKey(key)) {
                list.remove(key);
                list.addLast(key);
                return map.get(key);
            }
            return null;
        }

        Set<K> keSet() {
            return map.keySet();
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
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
