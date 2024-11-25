package com.qxlx.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author qxlx
 * @date 2024/11/25 21:43
 */
@Configuration
@ComponentScan("com.qxlx.event")
public class AppConfig {

//    @EventListener
//    public void listening (ApplicationEvent event) {
//        System.out.println("公共监听器:"+event.getClass().getName());
//    }

    @EventListener
    public void listening4 (MyTestEvent event) {
        System.out.println("MyTestEvent:"+event.getClass().getName());
    }

    @EventListener
    public void listening2 (UserCloseEvent event) {
        System.out.println("注解监听器===>UserCloseEvent->发送了一个注销用户短信"+event.getClass().getName());
    }

    @EventListener
    public void listening3 (UserCloseEvent event) {
        System.out.println("注解监听器===>UserCloseEvent->发送了一个注销用户的召回申请WA"+event.getClass().getName());
    }

}
