package com.java.repo.code.collections;

import lombok.val;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * LinkedHashMap 内部维护一个双向链表，该链表的决定了遍历Map中元素的顺序。
 * @author GuJun
 * @date 2020/12/31
 */
public class LinkedHashMapDemo {

    // 访问顺序
    private static void accessOrderDemo() {
        {
            Map<Integer, String> map = new LinkedHashMap<>();
            for (int i = 0; i < 100; ++i) {
                map.put(i, "value: " + i);
            }
            for (int i = 0; i < 10; ++i) {
                map.get(ThreadLocalRandom.current().nextInt(0, 100));
            }
            for (val entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue()); // 便利LinkedHashMap时，默认按照插入顺序输出
            }
        }
        {
            Map<Integer, String> map = new LinkedHashMap<>(100, .75f, true); // 按照访问排序
            for (int i = 0; i < 100; ++i) {
                map.put(i, "value: " + i);
            }
            for (int i = 0; i < 10; ++i) {
                map.get(ThreadLocalRandom.current().nextInt(0, 100)); // 访问过的数据会排到LinkedList的尾部
            }
            for (val entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue()); // 便利LinkedHashMap时，LinkedList顺序输出
            }
        }

    }


    public static void main(String[] args) {
        accessOrderDemo();
    }
}
