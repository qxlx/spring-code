package com.qxlx.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qxlx
 * @date 2024/12/8 15:27
 */
public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserService bean = (IUserService) ioc.getBean("userSercice");
        bean.add();

        System.out.println("=============");

//        bean.delete();
        // 因为bean是一个代理类 直接调用时可以使用的
    }

}
