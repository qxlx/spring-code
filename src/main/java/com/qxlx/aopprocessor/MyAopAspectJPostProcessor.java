package com.qxlx.aopprocessor;


import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

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
        if (PointcutAdvisor.class.isAssignableFrom(bean.getClass())) {
            return bean;
        }

        ListableBeanFactory listableBeanFactory =(ListableBeanFactory) beanFactory;
        String[] beanNamesForType = listableBeanFactory.getBeanNamesForType(PointcutAdvisor.class);
        List<PointcutAdvisor> pointcutAdvisorList = new ArrayList<>();

        for (String beanNameType : beanNamesForType) {
            PointcutAdvisor pointcutAdvisor = beanFactory.getBean(beanNameType, PointcutAdvisor.class);
            pointcutAdvisorList.add(pointcutAdvisor);
        }

        return Proxy.newProxyInstance(MyAopAspectJPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(),new MyInvocationHandler(pointcutAdvisorList, bean));
    }

}
