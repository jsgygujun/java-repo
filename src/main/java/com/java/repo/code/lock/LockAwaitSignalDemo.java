package com.java.repo.code.lock;

import java.util.concurrent.locks.LockSupport;

/**
 *
 * LockSupport 主要方法
 * park(); // 挂起当前线程，知道超时或者中断等条件出现
 * unpark(Thread thread) // 恢复指定线程运行
 * @author GuJun
 * @date 2020/12/20
 */
public class LockAwaitSignalDemo {

    public static void main(String[] args) {
        Thread bbb = new Thread(() -> {
            System.out.println("等待中...");
            LockSupport.park(); // 挂起当前线程「bbb」
            System.out.println("被唤醒!");
        }, "BBB");
        bbb.start();

        Thread aaa = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(bbb); // 恢复线程「bbb」
        }, "AAA");
        aaa.start();
    }
}
