package com.qxlx.aopprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/12/8 16:08
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = (UserService) ioc.getBean("userServiceImpl");
        userService.add();
    }

}
