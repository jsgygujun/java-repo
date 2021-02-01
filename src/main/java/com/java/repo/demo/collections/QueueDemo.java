package com.java.repo.demo.collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 创建实例 Queue<Object> queue = new LinkedList<>();
 * 元素入队 queue.offer(new Object());
 * 元素出队 Object obj = queue.poll();
 * 队首元素 Object obj = queue.peek();
 *
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
