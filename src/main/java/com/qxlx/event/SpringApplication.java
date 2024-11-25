package com.qxlx.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/11/25 21:43
 */
public class SpringApplication {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        MyTestEventPubLisher myTestEventPubLisher = ioc.getBean(MyTestEventPubLisher.class);
        myTestEventPubLisher.pushUserCloseListener("注销用户");

        TimeUnit.SECONDS.sleep(10);

        ioc.close();
    }

}
