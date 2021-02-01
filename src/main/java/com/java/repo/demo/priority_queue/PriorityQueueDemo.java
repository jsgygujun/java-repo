package com.java.repo.demo.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author GuJun
 * @date 2021/1/3
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        minHeap();
        maxHeap();
    }

    // 小项堆
    private static void minHeap() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Integer::compareTo);
        for (int i = 0; i < 10; ++i) {
            pq.add(ThreadLocalRandom.current().nextInt(0, 1000));
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
    // 大项堆
    private static void maxHeap() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Comparator.reverseOrder());
        for (int i = 0; i < 10; ++i) {
            pq.add(ThreadLocalRandom.current().nextInt(0, 1000));
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
