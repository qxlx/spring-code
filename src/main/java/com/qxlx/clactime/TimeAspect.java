package com.qxlx.clactime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;

/**
 * @author qxlx
 * @date 2024/11/22 21:52
 */
@Aspect
@Component
public class TimeAspect {

    private static final Logger log = LoggerFactory.getLogger(TimeAspect.class);

    @Pointcut("execution(* com.qxlx.clactime.UserServiceImpl.*(..))")
    public void pointCuts() {

    }

    @Around("pointCuts()")
    public Object arounds(ProceedingJoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Signature signature = joinPoint.getSignature();

        log.info(Thread.currentThread().getName()+"\t【注解】日志记录执行开始 ===== ");
        // 方法执行
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            return e;
        } finally {
            stopWatch.stop();
            TimeHolder.setMethodTime(((MethodSignature) signature).getMethod().getName(), BigDecimal.valueOf(stopWatch.getTotalTimeSeconds()));
            // 方法执行后
            System.out.println(Thread.currentThread().getName()+"\t【注解】日志记录执行完毕 ===== ");
        }
    }

}
