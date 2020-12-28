package com.java.repo.code.proxy.dynamic_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author GuJun
 * @Date 2020/12/28
 */
public class CglibProxyDemo implements MethodInterceptor {
    public Object newInstall(Object object) {
        return Enhancer.create(object.getClass(), this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("你被CglibProxy代理了～");
        return methodProxy.invokeSuper(o, objects);
    }

    @Test
    public void test() {
        CglibProxyDemo cglibProxyDemo = new CglibProxyDemo();
        UserApi userApi = (UserApi) cglibProxyDemo.newInstall(new UserApi());
        String result = userApi.queryUserInfo();
        System.out.println(result);
    }
}
