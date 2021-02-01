package com.java.repo.demo.annotation.myjunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author GuJun
 * @Date 2021/1/10
 */
public class MyJunitFrameWork {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        // 1. 找到测试类的字节码: UserDAOTest
        Class<?> clazz = UserDAOTest.class;
        Object obj = clazz.newInstance();
        // 2. 获取UserDAOTest类中所有的公共方法
        Method[] methods = clazz.getMethods();
        // 3. 迭代出每个Method对象判断哪些方法上使用了@MyBefore/@MyAfter/@MyTest注解
        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                myBeforeList.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                myAfterList.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                myTestList.add(method);
            }
        }
        // 4. 执行方法测试
        for (Method method : myTestList) {
            for (Method before : myBeforeList) {
                before.invoke(obj);
            }
            method.invoke(obj);
            for (Method after : myAfterList) {
                after.invoke(obj);
            }
        }
    }
}
