package com.qxlx.tx.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/12/16 21:07
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) ioc.getBean("userServiceImpl");
        User user = new User();
        user.setName("Qxlx");
        user.setAge(27);

        userService.register(user);
    }

}
