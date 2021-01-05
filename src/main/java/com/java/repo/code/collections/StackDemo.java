package com.java.repo.code.collections;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Java 中的 Stack 继承了 Vector，加了锁。
 * 应该使用 Deque 来替换 Stack
 *
 * @Author GuJun
 * @Date 2021/1/4
 */
public class StackDemo {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
