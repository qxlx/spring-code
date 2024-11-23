package com.qxlx.application;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author qxlx
 * @date 2024/11/20 21:53
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//        BeanDefinition beanDefinition = new GenericBeanDefinition();
//        registry.registerBeanDefinition("coder", new Coder());
    }
}
