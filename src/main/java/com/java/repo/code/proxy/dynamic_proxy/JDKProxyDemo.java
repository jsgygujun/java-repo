package com.java.repo.code.proxy.dynamic_proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 代理
 * 使用场景： 中间件开发、设计模式中代理模式和装饰器模式应用
 * 特点： 折衷JDK自带的类代理方式是非常常用的一种，也是非常简单的一种。基本会在一些中间件代码里看到，例如： 数据库路由组件、Redis组件等，同时也可以
 * 使用这样的方式应用到设计模式中。
 * 注意： 使用JDK的动态代理时，目标类必须实现接口才能代理
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class JDKProxyDemo {

    // 创建动态代理对象
    static class ProxyFactory {
        // 维护一个目标对象
        private Object target;
        public ProxyFactory(Object target) {
            this.target = target;
        }

        // 为目标对象创建代理对象
        public Object getProxyInstance() {
            return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("[前置通知]");
                            Object returnValue = method.invoke(target, args);//执行目标对象方法
                            System.out.println("[后置通知]");
                            return returnValue;
                        }
                    }

            );
        }
    }


    @Test
    public void test_JDK_proxy() throws Exception {
        IUserApi userApi = new UserApi();
        IUserApi proxy = (IUserApi) new ProxyFactory(userApi).getProxyInstance();
        System.out.println(proxy.queryUserInfo());
    }
}
