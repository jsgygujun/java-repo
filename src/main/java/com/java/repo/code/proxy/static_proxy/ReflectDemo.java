package com.java.repo.code.proxy.static_proxy;

import java.lang.reflect.Method;

/**
 * 在反射中可以调用方法、获取属性、拿到注解等相关内容。
 * 这些都可以于类代理组合使用，完成各种该框架中的技术场景
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        Class<UserMapper> clazz = UserMapper.class;
        Method jdbcOp = clazz.getMethod("jdbcOp");
        Object invoke = jdbcOp.invoke(clazz.newInstance());
    }
}
