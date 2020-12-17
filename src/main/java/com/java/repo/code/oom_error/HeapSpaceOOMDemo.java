package com.java.repo.code.oom_error;

// -Xms1m
// -Xmx2m
public class HeapSpaceOOMDemo {

    static void heapSpaceOOM() {
        byte[] bytes = new byte[3*1024*1024];
    }

    public static void main(String[] args) {
        try {
            heapSpaceOOM();
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
