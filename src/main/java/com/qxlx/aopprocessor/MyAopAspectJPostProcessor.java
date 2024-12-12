package com.qxlx.aopprocessor;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qxlx
 * @date 2024/12/8 16:05
 */
//@Component
public class MyAopAspectJPostProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {

    private BeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 获取接口的实现类
        // 切入点+额外功能 切面(Advisor)
//        final Pointcut pointcut = beanFactory.getBean(Pointcut.class);
//        final MethodBeforeAdvice methodBeforeAdvice = beanFactory.getBean(MethodBeforeAdvice.class);

        final PointcutAdvisor pointcutAdvisor = beanFactory.getBean(PointcutAdvisor.class);

        return Proxy.newProxyInstance(MyAopAspectJPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

                if (pointcutAdvisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                    if (pointcutAdvisor.getPointcut().getMethodMatcher().matches(method, bean.getClass())) {
                        if (pointcutAdvisor.getAdvice() instanceof MethodBeforeAdvice) {
                            ((MethodBeforeAdvice)pointcutAdvisor.getAdvice()).before(method, objects, bean);
                        }
                        return method.invoke(bean, objects);
                    }
                }
                return method.invoke(bean, objects);
            }
        });
    }

}
