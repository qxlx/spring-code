package com.qxlx.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qxlx
 * @date 2024/12/8 15:08
 */
@Configuration
// spring 会把当前的代理对象,存放在threadlocal当中
@EnableAspectJAutoProxy(exposeProxy = true)//(proxyTargetClass = true)
@ComponentScan("com.qxlx.aop")
public class AppConfig {

}
