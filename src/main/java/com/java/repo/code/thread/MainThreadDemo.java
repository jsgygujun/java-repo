package com.java.repo.code.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1. 主线程退出，子线程（非守护线程）不会退出
 * 2. 主线程退出，子线程（守护线程）退出
 * 3. 创建一个线程池（非守护线程），主线程退出，JVM不会退出
 * @author GuJun
 * @date 2020/12/21
 */
public class MainThreadDemo {

    /**
     * 主线程退出，只要存在非daemon子线程，则JVM不会退出
     */
    private static void mainThreadExit() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " exit~~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "subThread").start();
        System.out.println("mainThread exit~~~");
    }

    /**
     * 主线程退出，只存在daemon子线程，则JVM退出
     */
    private static void mainThreadExitDaemonThread() {
        Thread daemonThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " exit~~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "daemonSubThread");
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("mainThread exit~~~");
    }

    private static void mainThreadExecutors() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "doing job~");
        });
        System.out.println("mainThread exit~~~");
    }

    public static void main(String[] args) {
        //mainThreadExit();
        //mainThreadExitDaemonThread();
        mainThreadExecutors();
    }
}
