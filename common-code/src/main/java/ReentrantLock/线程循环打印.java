package ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 线程循环打印 {

    // 资源类
    static class Resource {
        private int number = 1;
        private Lock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        // 判断 -> 干活 -> 唤醒
        void print1() throws Exception {
            lock.lock();
            try {
                while (number != 1) {
                    c1.await();
                }
                System.out.println(Thread.currentThread().getName() + "\tnumber:" + number);
                number = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }
        }
        // 判断 -> 干活 -> 唤醒
        void print2() throws Exception {
            lock.lock();
            try {
                while (number != 2) {
                    c2.await();
                }
                System.out.println(Thread.currentThread().getName() + "\tnumber:" + number);
                number = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }
        }

        // 判断 -> 干活 -> 唤醒
        void print3() throws Exception {
            lock.lock();
            try {
                while (number != 3) {
                    c3.await();
                }
                System.out.println(Thread.currentThread().getName() + "\tnumber:" + number);
                number = 1;
                c1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final Resource resource = new Resource();
        new Thread(()->{
            try {
                for (int i = 0; i < 100; ++i) {
                    resource.print1();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 100; ++i) {
                    resource.print2();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 100; ++i) {
                    resource.print3();
                }
                resource.print3();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "C").start();

        Thread.sleep(10000);
    }
}
