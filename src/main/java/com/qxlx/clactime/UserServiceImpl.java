package com.qxlx.clactime;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/11/22 21:50
 */
@Component
public class UserServiceImpl implements UserService{

    @Override
    public void creditApply() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("creditApply");
    }

    @Override
    public void creditQuery() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("creditQuery");
    }

    @Override
    public void loanApply() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("loanApply");
    }

    @Override
    public void loanQuery() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("loanQuery");
    }
}
