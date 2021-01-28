package com.java.repo.code.proxy.dynamic_proxy.jdk;

import com.java.repo.code.proxy.dynamic_proxy.UserApi;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 代理
 * 在 Java 动态代理机制中 「InvocationHandler」 接口和 「Proxy」 类是核心。
 * 「Proxy」 类中使用频率最高的方法是：newProxyInstance() ，这个方法主要用来生成一个代理对象。
 *
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
    static class JDKProxyFactory {
        // 维护一个目标对象
        private final Object target;
        public JDKProxyFactory(Object target) {
            this.target = target;
        }

        // 为目标对象创建代理对象
        // 你通过Proxy 类的 newProxyInstance() 创建的代理对象在调用方法的时候，实际会调用到实现InvocationHandler 接口的类的 invoke()方法。
        // 你可以在 invoke() 方法中自定义处理逻辑，比如在方法执行前后做什么事情。
        public Object getProxyInstance() {
            // 生成一个代理对象
            return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(), // 类加载器，用于加载代理对象
                    target.getClass().getInterfaces(), // 被代理类实现的一些接口
                    // 实现 InvocationHandler 接口的对象
                    new InvocationHandler() {
                        /**
                         * 处理逻辑
                         * @param proxy 动态生成的代理类
                         * @param method 与代理类对象调用的方法相对应
                         * @param args 当前 method 方法的参数
                         * @return
                         * @throws Throwable
                         */
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
        IUserApi proxy = (IUserApi) new JDKProxyFactory(userApi).getProxyInstance();
        proxy.queryUserInfo();
    }
}
