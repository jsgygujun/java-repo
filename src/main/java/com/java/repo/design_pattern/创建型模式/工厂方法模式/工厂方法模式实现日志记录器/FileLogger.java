package com.java.repo.design_pattern.创建型模式.工厂方法模式.工厂方法模式实现日志记录器;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("File write log...");
    }
}
