package com.qxlx.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/12/8 15:27
 */
public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        UserSercice bean = ioc.getBean(UserSercice.class);
        bean.add();

    }

}
