package com.qxlx.aop;

import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/12/8 15:25
 */
@Component
public class UserSercice implements IUserService{

    public void add(){
        System.out.println("add");
    }

}
