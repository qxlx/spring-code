package com.qxlx.aopprocessor;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qxlx
 * @date 2024/12/8 16:14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyAopAspectJPostProcessor.class)
public @interface MyEnableAspectjAutoProxy {
}
