package com.qxlx.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
@Deprecated
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
 
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
      System.out.println("事件触发："+event.getClass().getName());
    }
}