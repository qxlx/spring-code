package com.qxlx.configuration;

import com.qxlx.application.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/12/1 12:06
 */
public class SpringApplictionTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ioc.getBean(AppConfig.class);

        User user = ioc.getBean(User.class);
        User user2 = ioc.getBean(User.class);

        System.out.println(user == user2);
    }

}
