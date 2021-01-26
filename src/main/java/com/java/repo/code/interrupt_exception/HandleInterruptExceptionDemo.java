package com.java.repo.code.interrupt_exception;

/**
 * 中断线程的方法， 调用Thread.interrupt方法。
 * 被中断的线程：
 *              1. 抛出了InterruptedException异常
 *              2. Thread.currentThread().isInterrupted()标志被置为1
 *
 * @author GuJun
 * @date 2021/1/26
 */
public class HandleInterruptExceptionDemo {

    // CPU密集型工作
    private static class CPUIntensiveJob extends Thread {
        @Override
        public void run() {
            int counter = 0;
            // 测试中断标志，并不会清除该标志
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("CPU密集型工作线程 run() " + ++counter);
            }
            System.out.println("当前工作线程接收到了中断信号，退出while循环～");
        }
    }

    private static class IOIntensiveJob extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 1000; ++i) {
                    Thread.sleep(100);
                    System.out.println("IO密集型工作线程 run() " + i);
                }
            } catch (InterruptedException e) {
                // 当外部调用线程对象的interrupt方法时，程序执行到这里。
                e.printStackTrace();
            } finally {
                System.out.println("当前工作线程被中断了，到这里执行清理工作！");
            }
        }
    }

    private void interruptCPUIntensiveJobDemo() throws Exception {
        Thread t = new CPUIntensiveJob();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        Thread.sleep(3000);
    }

    private void interruptIOIntensiveJobDemo() throws Exception {
        Thread t = new IOIntensiveJob();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        Thread.sleep(3000);
    }

    public static void main(String[] args) throws Exception {
        HandleInterruptExceptionDemo demo = new HandleInterruptExceptionDemo();
        //demo.interruptCPUIntensiveJobDemo();
        demo.interruptIOIntensiveJobDemo();
    }
}
