package com.qxlx.springmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qxlx
 * @date 2024/11/21 21:59
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void register() {
        userDao.save();
    }
}
