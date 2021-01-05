package com.java.repo.code.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @Author GuJun
 * @Date 2021/1/4
 */
public class ArrayDequeDemo {

    static void useAsStack() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 10; ++i) {
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        useAsStack();
    }
}
