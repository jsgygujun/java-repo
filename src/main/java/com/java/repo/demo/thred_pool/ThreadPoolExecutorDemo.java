package com.java.repo.demo.thred_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private static void doTask(String taskName) {
        try {
            System.out.println(Thread.currentThread().getName() + " doing task-" + taskName);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 调用shutdown，任务队列不再接受新任务，但会把已经在任务队列中的任务执行完
    private static void shutdown() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; ++i) {
            final int taskId = i;
            executor.submit(() -> doTask(String.valueOf(taskId)));
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown(); // 调用完shutdown，主线程不会被阻塞！
        System.out.println(executor.isShutdown()); // true
        while (!executor.isTerminated()) {
            System.out.println("\n\nstatistics:");
            System.out.println("activeCount: " + executor.getActiveCount()); // 有效线程数量
            System.out.println("completedTaskCount: " + executor.getCompletedTaskCount()); // 完成任务个数
            System.out.println("corePoolSize: " + executor.getCorePoolSize()); // 核心线程数
            System.out.println("maximumPoolSize: " + executor.getMaximumPoolSize()); // 最大线程数
            System.out.println("taskCount: " + executor.getTaskCount()); // 任务数
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MainThread exit.");
    }

    // 调用shutdownNow，任务队列不再接受新任务，也不会执行任务队列中的任务，会发送中断给每个工作线程
    private static void shutdownNow() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; ++i) {
            final int taskId = i;
            executor.submit(() -> doTask(String.valueOf(taskId)));
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdownNow(); // 调用完shutdown，主线程不会被阻塞！
        System.out.println(executor.isShutdown()); // true
        while (!executor.isTerminated()) {
            System.out.println("\n\nstatistics:");
            System.out.println("activeCount: " + executor.getActiveCount()); // 有效线程数量
            System.out.println("completedTaskCount: " + executor.getCompletedTaskCount()); // 完成任务个数
            System.out.println("corePoolSize: " + executor.getCorePoolSize()); // 核心线程数
            System.out.println("maximumPoolSize: " + executor.getMaximumPoolSize()); // 最大线程数
            System.out.println("taskCount: " + executor.getTaskCount()); // 任务数
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MainThread exit.");
    }

    public static void main(String[] args) {
        //shutdown();
        shutdownNow();
    }
}
