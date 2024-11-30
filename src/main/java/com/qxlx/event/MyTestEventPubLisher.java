package com.qxlx.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyTestEventPubLisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public void pushUserCloseListener(String msg) {
        applicationEventPublisher.publishEvent(new UserCloseEvent(this, msg));
    }

}