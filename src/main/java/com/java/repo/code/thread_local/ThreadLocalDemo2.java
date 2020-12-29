package com.java.repo.code.thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author GuJun
 * @date 2020/12/29
 */
public class ThreadLocalDemo2 {

    private static void memoryLeakageDemo() {
        ExecutorService es = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 100; ++i) {
            final int n = i;
            es.submit(() -> {
                ThreadLocal<String> val = new ThreadLocal<>();
                val.set("Hello- " + n);
                System.gc();
            });
        }
        es.shutdown();
    }

    public static void main(String[] args) {
        memoryLeakageDemo();
    }
}
