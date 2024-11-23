package com.qxlx.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/11/23 10:52
 */
public class SpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService bean = ioc.getBean(UserService.class);
    }

}
