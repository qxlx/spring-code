package com.qxlx.myeventbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 定义执行事件驱动封装类
 */
public class ObserverAction {
    // 记录要执行对象的实例
    private Object target;
    // 记录要执行的方法
    private Method method;

    public ObserverAction(Object target, Method method) {
        // 存储必要的信息
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    // event是method方法的参数
    public void execute(Object event) {
        try {
            // 反射调用执行
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}