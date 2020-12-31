package com.java.repo.code.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuJun
 * @date 2020/12/31
 */
public class HashMapDemo {

    // key 可以为 null ?
    private static void nullKeyDemo() {
        Map<String, String> map = new HashMap<>();
        map.put(null, "value:null");// ok， key为null，其hashCode=0
        System.out.println(map.get(null)); // "value:null"
        map.put(null, "value:null2");// ok，替换key为null的值
        System.out.println(map.get(null)); // "value:null2"
    }

    public static void main(String[] args) {
        nullKeyDemo();
    }
}
