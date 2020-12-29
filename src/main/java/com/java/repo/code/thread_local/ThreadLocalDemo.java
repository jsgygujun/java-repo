package com.java.repo.code.thread_local;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GuJun
 * @date 2020/12/29
 */
public class ThreadLocalDemo {

    static class ThreadId {
        private static final AtomicInteger nextId = new AtomicInteger(0);

        private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);

        public static int get() {
            return threadId.get();
        }
    }

    static class SessionUtil {
        private static final ThreadLocal<String> threadLocalSession = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

        private static void set(String session) {
            threadLocalSession.set(session);
        }

        private static String get() {
            return threadLocalSession.get();
        }

        private static void remove() {
            threadLocalSession.remove();
        }
    }

    private static void threadIdDemo() {
        for (int i = 0; i < 100; ++i) {
            new Thread(() -> {
                System.out.println("threadId: " + ThreadId.get());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
    }

    private static void generateSession() {
        SessionUtil.set(Thread.currentThread().getName() + " : " + UUID.randomUUID().toString());
    }

    private static void accessSession() {
        System.out.println(Thread.currentThread().getName() + " ==> " + SessionUtil.get());
    }

    private static void removeSession() {
        SessionUtil.remove();
    }


    private static void sessionDemo() {
        for (int i = 0; i < 200; ++i) {
            new Thread(() -> {
                generateSession();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                accessSession();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removeSession();
            }, "Thread-" + i).start();
        }
    }

    private static void sessionDemo2() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 200; ++i) {
            es.submit(() -> {
                generateSession();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                accessSession();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();
    }

    private static void memoryLeakageDemo2() {
        ExecutorService es = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 100; ++i) {
            es.submit(() -> {
                List<ThreadLocal<String>> list = new ArrayList<>();
                for (int j = 0; j < 100; ++j) {
                    ThreadLocal<String> val = new ThreadLocal<>();
                    val.set("Hello- " + j);
                    list.add(new ThreadLocal<>());
                }
                System.gc();
            });
        }
        es.shutdown();
    }

    public static void main(String[] args) {
//         sessionDemo();
//         sessionDemo2();
//        memoryLeakageDemo();
//        memoryLeakageDemo2();
    }

}
