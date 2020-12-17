package com.java.repo.code.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 一个Lock对象，多个Condition对象
// 实现多线程循环打印
public class OneLockMultiConditionsDemo {

    static class SharedResource {
        private final Lock lock = new ReentrantLock();
        private final AtomicInteger counter = new AtomicInteger(0);
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        private void f1() {
            lock.lock();
            try {
                while (counter.get() % 3 != 0) {
                    c1.await();
                }
                System.out.println(Thread.currentThread().getName() + "\tCounter: " + counter);
                counter.incrementAndGet();
                c2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void f2() {
            lock.lock();
            try {
                while (counter.get() % 3 != 1) {
                    c2.await();
                }
                System.out.println(Thread.currentThread().getName() + "\tCounter: " + counter);
                counter.incrementAndGet();
                c3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void f3() {
            lock.lock();
            try {
                while (counter.get() % 3 != 2) {
                    c3.await();
                }
                System.out.println(Thread.currentThread().getName() + "\tCounter: " + counter);
                counter.incrementAndGet();
                c1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final SharedResource sharedResource = new SharedResource();
        new Thread(()->{
            for (int i = 0; i < 10; ++i) {
                sharedResource.f1();
            }
        }, "T1").start();

        new Thread(()->{
            for (int i = 0; i < 10; ++i) {
                sharedResource.f2();
            }
        }, "T2").start();

        new Thread(()->{
            for (int i = 0; i < 10; ++i) {
                sharedResource.f3();
            }
        }, "T3").start();

    }

}
