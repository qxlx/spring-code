package com.qxlx.springmybatis;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

/**
 * @author qxlx
 * @date 2024/11/21 22:00
 */
public class MyImportRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        final BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
        final GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        registry.registerBeanDefinition("userDao",beanDefinition);
    }
}
