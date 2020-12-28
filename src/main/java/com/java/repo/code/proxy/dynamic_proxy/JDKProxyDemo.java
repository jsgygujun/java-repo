package com.java.repo.code.proxy.dynamic_proxy;

import com.java.repo.code.proxy.static_proxy.JDKProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author GuJun
 * @Date 2020/12/28
 */
public class JDKProxyDemo {
    public static <T> T getProxy(Class clazz) throws Exception {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(cl, new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(" 你被代理了，by JDKProxy");
                return "hahahaha";
            }
        });
    }

    @Test
    public void test_JDK_proxy() throws Exception {
        IUserApi userApi = JDKProxy.getProxy(IUserApi.class);
        String result = userApi.queryUserInfo();
        System.out.println(result);
    }
}
