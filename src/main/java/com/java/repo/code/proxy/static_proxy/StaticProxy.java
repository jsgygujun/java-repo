package com.java.repo.code.proxy.static_proxy;

/**
 * 代理者，类似中介
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
