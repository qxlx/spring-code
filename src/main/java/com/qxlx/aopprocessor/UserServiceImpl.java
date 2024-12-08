package com.qxlx.aopprocessor;

import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/12/8 16:06
 */
@Component
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("add");
    }
}
