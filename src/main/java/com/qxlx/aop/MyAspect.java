package com.qxlx.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/12/8 15:15
 */
@Component
@Aspect
public class MyAspect {

    @Before("execution(* com.qxlx.aop.UserSercice.*(..))")
    public void before(){
        System.out.println("before");
    }

    @After("execution(* com.qxlx.aop.UserSercice.*(..))")
    public void after(){
        System.out.println("after");
    }
}
