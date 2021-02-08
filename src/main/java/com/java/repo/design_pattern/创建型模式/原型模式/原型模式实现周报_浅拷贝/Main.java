package com.java.repo.design_pattern.创建型模式.原型模式.原型模式实现周报_浅拷贝;

/**
 * @author GuJun
 * @date 2021/2/8
 */
public class Main {

    public static void main(String[] args) {
        WeeklyLog lastWeeklyLog = new WeeklyLog();
        lastWeeklyLog.setName("张无忌");
        lastWeeklyLog.setDate("第12周");
        lastWeeklyLog.setContent("这周工作很忙，每天加班～");
        System.out.println(lastWeeklyLog);
        WeeklyLog newWeeklyLog = lastWeeklyLog.clone();
        newWeeklyLog.setDate("第13周");
        System.out.println(newWeeklyLog);
    }

}
