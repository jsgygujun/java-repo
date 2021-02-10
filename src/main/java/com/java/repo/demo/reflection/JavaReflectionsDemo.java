package com.java.repo.demo.reflection;

import lombok.Data;

import java.util.Arrays;

/**
 * @author GuJun
 * @date 2021/2/10
 */
public class JavaReflectionsDemo {

    @Data
    static class Foo {
        private String name;
        public void func() {
            System.out.println("func");
        }
    }

    // 获取Class对象的方法： 两种
    private static void getClassObject() throws ClassNotFoundException, NoSuchMethodException {
        Class<Foo> fooCls = Foo.class; // 知道具体的类
        Class<?> fooCls2 = Class.forName("com.java.repo.demo.reflection.JavaReflectionsDemo"); // 动态获取Class对象
        System.out.println(fooCls.getName()); // 获取全类名，com.java.repo.demo.reflection.JavaReflectionsDemo$Foo
        System.out.println(fooCls.getSimpleName()); // 获取类名：Foo
        System.out.println(fooCls.getModifiers()); // 获取类的修饰符：8
        System.out.println(fooCls.getPackage()); // 获取包名： package com.java.repo.demo.reflection
        System.out.println(fooCls.getSuperclass()); // 获取父类名： class java.lang.Object
        System.out.println(Arrays.asList(fooCls.getInterfaces())); // 获取接口
        System.out.println(fooCls.getMethod("func"));
    }

    public static void main(String[] args) throws Exception {
        getClassObject();
    }
}
