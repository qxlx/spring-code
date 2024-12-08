package com.qxlx.aopprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qxlx
 * @date 2024/12/8 16:05
 */
//@Component
public class MyAopAspectJPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       return Proxy.newProxyInstance(MyAopAspectJPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("MyAopAspectJPostProcessor");
                Object object = method.invoke(bean, objects);
                return object;
            }
        });
    }
}
