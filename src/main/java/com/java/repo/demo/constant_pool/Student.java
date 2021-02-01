package com.java.repo.demo.constant_pool;

import lombok.Data;

/**
 * @author GuJun
 * @date 2021/1/19
 */
@Data
public class Student {
    Integer age;
    String name;

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(333);
        s1.setName("张三");

        Student s2 = new Student();
        s2.setAge(333);
        s1.setName("李四");

        System.out.println(s1.getAge() == s2.getAge()); // false
    }
}
