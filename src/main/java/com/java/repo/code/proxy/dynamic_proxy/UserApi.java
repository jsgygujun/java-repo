package com.java.repo.code.proxy.dynamic_proxy;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author GuJun
 * @Date 2020/12/28
 */
public class UserApi implements IUserApi {
    @Override
    public void queryUserInfo() {
        System.out.println("执行业务逻辑～～");
    }

    /**
     * 反射示例
     * @throws Exception
     */
    @Test
    public void test_reflect() throws Exception {
        Class<UserApi> clazz = UserApi.class;
        Method queryUserInfo = clazz.getMethod("queryUserInfo");
        queryUserInfo.invoke(clazz.newInstance());
    }
}
