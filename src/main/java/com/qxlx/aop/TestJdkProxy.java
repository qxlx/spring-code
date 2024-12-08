package com.qxlx.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qxlx
 * @date 2024/12/8 15:45
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        UserSercice userSercice = new UserSercice();

        Object proxyInstance = Proxy.newProxyInstance(UserSercice.class.getClassLoader(), new Class[]{IUserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("jdk before");
                        Object object = method.invoke(userSercice,objects);
                        System.out.println("jkd after");
                        return object;
                    }
                });

        IUserService userService = (IUserService) proxyInstance;
        userService.add();
    }

}
