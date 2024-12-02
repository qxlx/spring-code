package com.qxlx.bfpp;

import com.qxlx.beanfactoryprocessor.A;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author qxlx
 * @date 2024/12/1 20:55
 */
public class TestCglib {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        A a = new A();
        enhancer.setSuperclass(A.class);
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("增加额外功能");
                return method.invoke(a, objects);
            }
        });

        A object = (A) enhancer.create();
        object.test();
    }

}
