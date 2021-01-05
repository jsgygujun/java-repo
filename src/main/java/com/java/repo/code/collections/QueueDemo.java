package com.java.repo.code.collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author GuJun
 * @Date 2021/1/4
 */
public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
