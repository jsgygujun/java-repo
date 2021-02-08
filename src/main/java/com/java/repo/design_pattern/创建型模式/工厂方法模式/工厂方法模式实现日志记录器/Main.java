package com.java.repo.design_pattern.创建型模式.工厂方法模式.工厂方法模式实现日志记录器;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Main {

    public static void main(String[] args) {
        LoggerFactory loggerFactory = new FileLoggerFactory();
        Logger logger = loggerFactory.newLogger();
        logger.writeLog();
        loggerFactory = new DatabaseLoggerFactory();
        logger = loggerFactory.newLogger();
        logger.writeLog();
    }
}
