package com.java.repo.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author GuJun
 * @date 2021/1/22
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<char[]> queue = new ReferenceQueue<>(); // 引用队列
        char[] obj = new char[1024*1024];
        PhantomReference<char[]> phantomRefObj = new PhantomReference<>(obj, queue);
        System.out.println(phantomRefObj.get() == null); // true
        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(queue.poll()); // java.lang.ref.PhantomReference@63947c6b
    }
}
