package org.qxlx.application;

import com.qxlx.application.AppConfig;
import com.qxlx.application.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

/**
 * @author qxlx
 * @date 2024/11/18 21:57
 */
public class Test1 {

    private static final Logger log = LoggerFactory.getLogger(Test1.class);

    @Test
    public void test3 () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext("org.qxlx.application");
        System.out.println(ioc.getBean("org.qxlx.application.Person"));
    }

    @Test
    public void test2 () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        Person bean = ioc.getBean(Person.class);
        Assert.notNull(bean);
    }

    @Test
    public void testBd () {
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        AbstractBeanDefinition beanDefinition = bdb.getBeanDefinition();
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.add("pwd", "123");

        ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
//        constructorArgumentValues.addArgumentValues("123");

        log.info(beanDefinition.toString());
        Assert.notNull(beanDefinition);
    }

}
