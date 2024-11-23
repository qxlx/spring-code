package com.qxlx.springmybatis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/11/21 22:14
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);

        UserServiceImpl userService = ioc.getBean(UserServiceImpl.class);

        userService.register();
    }

}
