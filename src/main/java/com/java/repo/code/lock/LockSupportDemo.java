package com.java.repo.code.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport 主要方法
 * 不需要锁，可以直接挂起和恢复线程
 * permit 许可证，每个线程都有一个，值为0、1。
 *
 * LockSupport 实际上是操作permit。
 *
 * park(); // 挂起当前线程，知道超时或者中断等条件出现
 * unpark(Thread thread) // 恢复指定线程运行
 *
 * @author GuJun
 * @date 2021/1/21
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread bbb = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待中...");
            LockSupport.park(); // 挂起当前线程「bbb」，如果已有线程恢复当前线程，则不会进入阻塞
            System.out.println("被唤醒!");
        }, "BBB");
        bbb.start();
        Thread aaa = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("unpark 恢复线程～～～");
            LockSupport.unpark(bbb); // 恢复线程「bbb」, unpark 在park 之前执行同样可以唤醒
        }, "AAA");
        aaa.start();
    }
}
