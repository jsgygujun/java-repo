package com.java.repo.code.annotation.myjunit;

/**
 * @Author GuJun
 * @Date 2021/1/10
 */
public class UserDAOTest {
    @MyBefore
    public void init() {
        System.out.println("初始化");
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁");
    }

    @MyTest
    public void save() {
        System.out.println("保存");
    }

    @MyTest
    public void delete() {
        System.out.println("删除");
    }
}
