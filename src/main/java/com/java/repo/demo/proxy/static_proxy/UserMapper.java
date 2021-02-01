package com.java.repo.demo.proxy.static_proxy;

/**
 *
 * 被代理对象
 * @author GuJun
 * @date 2020/12/27
 */
public class UserMapper implements Mapper {

    public void jdbcOp() {
        //System.out.println("========== 获取数据库链接 =========");
        System.out.println("========== 执行核心业务代码 UserMapper ==========");
        //System.out.println("========== 关闭链接 ==========");
    }
}
