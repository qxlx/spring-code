package com.qxlx.beanfactoryprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/11/23 21:05
 */
public class Test1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);

        A a = ioc.getBean(A.class);
        A a2 = ioc.getBean(A.class);

        System.out.println(a);
        System.out.println(a2);
    }

}
