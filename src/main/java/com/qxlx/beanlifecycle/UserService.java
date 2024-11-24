package com.qxlx.beanlifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author qxlx
 * @date 2024/11/23 10:50
 */
//@Service
public class UserService {

//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        userDao.saveData();
//    }



//    @PostConstruct
//    public void init () {
//        userDao.saveData();
//    }

    public void shutdown() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement);
        }

        System.out.println("shutDown");
    }


//    @Autowired
//    private UserDao userDao;
//
//    public UserService() {
//        userDao.saveData();
//    }

//    @Autowired
//    private UserService (UserDao userDao) {
//        userDao.saveData();
//    }









}
