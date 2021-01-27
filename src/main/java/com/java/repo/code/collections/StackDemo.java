package com.java.repo.code.collections;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Java 中的 Stack 继承了 Vector，加了锁。
 * 应该使用 Deque 来替换 Stack
 *
 * 创建实例 Deque<Object> stack = new LinkedList<>();
 * 元素入栈 stack.push(new Object());
 * 元素出栈 Object obj = stack.pop();
 * 栈顶元素 Object obj = stack.peek();
 *
 * @Author GuJun
 * @Date 2021/1/4
 */
public class StackDemo {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            stack.push(i); // 入栈
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // 栈顶元素
            System.out.println(stack.pop()); // 出栈
        }
    }
}
