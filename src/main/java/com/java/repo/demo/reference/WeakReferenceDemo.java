package com.java.repo.demo.reference;

import java.lang.ref.WeakReference;

/**
 * 只有弱引用引用着的对象活不过一次GC
 *
 * @author GuJun
 * @date 2021/1/22
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        char[] obj = new char[1024*1024];
        WeakReference<char[]> weakRefObj = new WeakReference<>(obj);
        System.out.println(weakRefObj.get() == null); // false;
        System.gc();
        obj = null;
        System.gc();
        System.out.println(weakRefObj.get() == null); // true;
    }
}
