package com.qxlx.springmybatis;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qxlx
 * @date 2024/11/21 22:08
 */
public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{UserDao.class}, (Object proxy, Method method, Object[] args) -> {
            System.out.println("这是DAO接口实现类");
            return null;
        });
        return newProxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
}
