package com.qxlx.clactime;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author qxlx
 * @date 2024/11/22 21:48
 */
public class SpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ioc.getBean(UserService.class);

        new Thread(()->{
            try {
                userService.creditApply();
                userService.creditQuery();
                userService.loanApply();
                ApiTimeMap threadApiTimeMap = TimeHolder.getThreadApiTimeMap();
                System.out.println(Thread.currentThread().getName()+"\t"+JSONUtils.toJSONString(threadApiTimeMap.getMap()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                TimeHolder.clear();
            }

        },"T1").start();


        new Thread(()->{
            try {
                userService.creditApply();
                userService.creditQuery();
                userService.loanApply();
                userService.loanQuery();
                ApiTimeMap threadApiTimeMap = TimeHolder.getThreadApiTimeMap();
                System.out.println(Thread.currentThread().getName()+"\t"+JSONUtils.toJSONString(threadApiTimeMap.getMap()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                TimeHolder.clear();
            }

        },"T2").start();
    }



}
