package com.java.repo.code.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用只有在内存不足的时候才会被GC
 *
 * @author GuJun
 * @date 2021/1/22
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        char[] obj = new char[1024*1024]; // 强引用
        SoftReference<char[]> softRefObj = new SoftReference<>(obj); // 软引用
        System.out.println(softRefObj.get() == null); // false;
        System.gc();
        obj = null;
        System.gc();
        System.out.println(softRefObj.get() == null); // false
    }
}
