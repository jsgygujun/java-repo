package com.java.repo.demo.proxy.static_proxy;

/**
 * 代理者，类似中介
 * 静态代理实现步骤:
 *
 * 1. 定义一个接口及其实现类；
 * 2. 创建一个代理类同样实现这个接口
 * 3. 将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法。
 *    这样的话，我们就可以通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些自己想做的事情。
 *
 * @author GuJun
 * @date 2020/12/27
 */
public class StaticProxy {

    // 对外提供代理服务
    public void startJdbcOp(Mapper mapper) {
        System.out.println("========== 获取数据库链接 =========");
        // 通知被代理对象，执行业务逻辑
        mapper.jdbcOp();
        System.out.println("========== 关闭链接 ==========");
    }

    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.startJdbcOp(new UserMapper());
        staticProxy.startJdbcOp(new AdminMapper());
    }
}
