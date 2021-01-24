package com.java.repo.code.proxy.dynamic_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Cglib代理，也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展。
 * 注意： 代理的类不能为final，代理的方法不能是private，final，static修饰的。
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class CglibProxyDemo {

    static class ProxyFactory implements MethodInterceptor {
        // 维护目标对象
        private final Object target;

        ProxyFactory(Object target) {
            this.target = target;
        }

        // 给目标对象创建一个代理对象
        Object getProxyInstance(){
            // 1.工具类
            Enhancer en = new Enhancer();
            // 2.设置父类
            en.setSuperclass(target.getClass());
            // 3.设置回调函数
            en.setCallback(this);
            // 4.创建子类(代理对象)
            return en.create();
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("前置通知");
            Object returnValue = method.invoke(target, args);//执行目标对象的方法
            System.out.println("后置通知");
            return returnValue;
        }
    }

    @Test
    public void test() {
        UserApi userApi = new UserApi();
        UserApi proxy = (UserApi) new ProxyFactory(userApi).getProxyInstance();
        proxy.queryUserInfo();
    }
}
