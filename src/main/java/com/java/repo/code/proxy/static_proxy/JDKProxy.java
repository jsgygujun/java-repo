package com.java.repo.code.proxy.static_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 代理
 * 使用场景： 中间件开发、设计模式中代理模式和装饰器模式应用
 * 特点： 折衷JDK自带的类代理方式是非常常用的一种，也是非常简单的一种。基本会在一些中间件代码里看到，例如： 数据库路由组件、Redis组件等，同时也可以
 * 使用这样的方式应用到设计模式中。
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> clazz) throws Exception {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(cl, new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + " 你被代理了， By JDKProxy!");
                return null;
            }
        });
    }



}
