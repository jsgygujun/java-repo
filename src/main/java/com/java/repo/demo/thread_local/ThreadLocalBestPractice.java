package com.java.repo.demo.thread_local;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal 类提供「线程局部变量」，这些变量与普通变量不同，线程每次通过get或者set访问的都是属于线程自己的，独立初始化的变量副本。
 * ThreadLocal 实例对象通常是将状态与线程关联的类中的私有「静态字段」。（例如，用户ID，交易ID）
 * 例如，下面的类生成每个线程本地的唯一标识符。线程的ID是在第一次调用ThreadId.get()时分配的，并且在后续调用中保持不变。
 *
 * @author GuJun
 * @date 2020/12/29
 */
public class ThreadLocalBestPractice {
    static class ThreadId {
        private static final AtomicInteger nextId = new AtomicInteger(0);
        private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);
        public static int get() {
            return threadId.get();
        }
    }

    static void threadIdDemo() {
        for (int i = 0; i < 100; ++i) {
            new Thread(() -> {
                System.out.println("threadId: " + ThreadLocalDemo.ThreadId.get());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
    }

    public static void main(String[] args) {
        threadIdDemo();
    }
}
