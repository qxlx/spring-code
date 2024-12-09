package com.qxlx.aop;

import com.qxlx.application.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/12/8 15:25
 */
@Component
public class UserSercice implements IUserService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void add(){
        System.out.println("add");
        System.out.println("this:"+this);

        // 获取代理对象 才可以执行 aop的逻辑
        // 方法1
//        delete();
//        IUserService userService = (IUserService) applicationContext.getBean("userSercice");
//        System.out.println("this2:"+userService);
//        userService.delete();


        // 方法2
        IUserService userService = (IUserService) AopContext.currentProxy();
        userService.delete();

        // JdkDynamicAopProxy 代理
//        if (this.advised.exposeProxy) {
//            // Make invocation available if necessary.
//            oldProxy = AopContext.setCurrentProxy(proxy);
//            setProxyContext = true;
//        }
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }



}
