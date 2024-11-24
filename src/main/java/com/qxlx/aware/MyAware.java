package com.qxlx.aware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * 后续推展使用
 * @author qxlx
 * @date 2024/11/24 16:55
 */
public class MyAware implements BeanFactoryAware, BeanNameAware, EnvironmentAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory)  {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware.setBeanName()");
    }

    @Override
    public void setEnvironment(Environment environment) {

    }
}
