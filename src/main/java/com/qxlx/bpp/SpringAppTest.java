package com.qxlx.bpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.Assert;

/**
 * @author qxlx
 * @date 2024/12/3 22:12
 */
@EnableAspectJAutoProxy
public class SpringAppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBeanPostProcessor myBeanPostProcessor = ioc.getBean(MyBeanPostProcessor.class);
        Assert.notNull(myBeanPostProcessor);
    }

}
