package com.java.repo.code.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/1/27
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }

        list.add(4, 1000); // 1000插入到index=4的位置上

        list.add(1000, 100000); // size小于插入index抛出异常。

        System.out.println(list);
    }
}
