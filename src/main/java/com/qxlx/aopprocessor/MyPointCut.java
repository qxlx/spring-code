package com.qxlx.aopprocessor;


import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author qxlx
 * @date 2024/12/12 21:04
 */
@Component
public class MyPointCut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                if (UserServiceImpl.class.isAssignableFrom(clazz)) {
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {

            // 判断方法
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                if ("add".equals(method.getName())) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean isRuntime() {
                return true;
            }

            @Override
            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                return matches(method, targetClass);
            }
        };
    }
}
