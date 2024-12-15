package com.qxlx.aopprocessor;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.PointcutAdvisor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qxlx
 * @date 2024/12/14 21:50
 */
public class MyInvocationHandler implements InvocationHandler {

    private List<PointcutAdvisor> pointcutAdvisorList;

    private Object target;

    private List<PointcutAdvisor> methodBeforeAdvisors = new ArrayList<>();

    private List<PointcutAdvisor> afterRetutningAdvisors = new ArrayList<>();

    public MyInvocationHandler(List<PointcutAdvisor> pointcutAdvisorList, Object target) {
        this.pointcutAdvisorList = pointcutAdvisorList;
        this.target = target;
        setAdviceList(pointcutAdvisorList);
    }

    // 数据初始化
    private void setAdviceList(List<PointcutAdvisor> pointcutAdvisorList) {
        for (PointcutAdvisor pointcutAdvisor : pointcutAdvisorList) {
            if (pointcutAdvisor.getAdvice() instanceof BeforeAdvice) {
                methodBeforeAdvisors.add(pointcutAdvisor);
            } else if (pointcutAdvisor.getAdvice() instanceof AfterReturningAdvice) {
                afterRetutningAdvisors.add(pointcutAdvisor);
            }
        }
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 执行beforeAdvice
        for (PointcutAdvisor pointcutAdvisor : methodBeforeAdvisors) {
            if (pointcutAdvisor.getPointcut().getClassFilter().matches(target.getClass())) {
                if (pointcutAdvisor.getPointcut().getMethodMatcher().matches(method, target.getClass())) {
                    ((MethodBeforeAdvice) pointcutAdvisor.getAdvice()).before(method, objects, target);
                }
            }
        }
        // 目标方法
        Object ret = method.invoke(target, objects);
        // 执行afterAdvice
        for (PointcutAdvisor pointcutAdvisor : afterRetutningAdvisors) {
            if (pointcutAdvisor.getPointcut().getClassFilter().matches(target.getClass())) {
                if (pointcutAdvisor.getPointcut().getMethodMatcher().matches(method, target.getClass())) {
                    ((AfterReturningAdvice) pointcutAdvisor.getAdvice()).afterReturning(ret, method, objects, target);
                }
            }
        }
        return ret;
    }
}
