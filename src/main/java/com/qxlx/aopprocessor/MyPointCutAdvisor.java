package com.qxlx.aopprocessor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/12/12 21:55
 */
@Component
public class MyPointCutAdvisor implements PointcutAdvisor, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public Pointcut getPointcut() {
        return new MyPointCut();
    }

    @Override
    public Advice getAdvice() {
        return beanFactory.getBean(MethodBeforeAdvice.class);
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
