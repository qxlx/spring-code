package com.qxlx.event;

import org.springframework.context.ApplicationEvent;

public class UserCloseEvent extends ApplicationEvent {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String msg ;

    public UserCloseEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}