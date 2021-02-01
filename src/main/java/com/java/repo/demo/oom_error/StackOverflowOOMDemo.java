package com.java.repo.demo.oom_error;

// -Xss[1024k]
public class StackOverflowOOMDemo {

    static void stackOverflowOOM(int i) {
        ++i;
        System.out.println("第[" + i + "]层～");
        stackOverflowOOM(i);
    }

    public static void main(String[] args) {
        int i = 0;
        try {
            stackOverflowOOM(i);
        } catch (Error e) {
            e.printStackTrace(); // Exception in thread "main" java.lang.StackOverflowError
        }
    }
}
