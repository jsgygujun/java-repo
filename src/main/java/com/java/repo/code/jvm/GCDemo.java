package com.java.repo.code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuJun
 * @date 2020/12/22
 */
public class GCDemo {

    // -Xms8m
    // -Xmx8m
    // -XX:+PrintCommandLineFlags
    // -XX:+PrintGCDetails
    // 输出： -XX:InitialHeapSize=104857600 -XX:MaxHeapSize=104857600 -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
    private static void defaultGC() {
        List<byte[]> data = new ArrayList<>();
        System.out.println("Start->");
        for (int i = 0; i < 100000; ++i) {
            //data.add(new byte[1024*1024]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // JDK8 默认GC -XX:+UseParallelGC
    // 指定GC -XX:+UseSerialGC
    // 输出-XX:+UseSerialGC
    // 指定GC -XX:+UseParNewGC
    // 输出-XX:+UseParNewGC "Using the ParNew young collector with the Serial old collector is deprecated and will likely be removed in a future release"


    public static void main(String[] args) {
        defaultGC();
    }
}
