package com.qxlx.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author qxlx
 * @date 2024/12/8 15:53
 */
public class CglibTest {

    public static void main(String[] args) {
        UserSercice userSercice = new UserSercice();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserSercice.class);
        enhancer.setClassLoader(CglibTest.class.getClassLoader());
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("cglib");
                return method.invoke(userSercice, objects);
            }
        });
        UserSercice object = (UserSercice)enhancer.create();

        object.add();
    }

}
