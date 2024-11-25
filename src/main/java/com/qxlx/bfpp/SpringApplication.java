package com.qxlx.bfpp;

import com.qxlx.beanfactoryprocessor.A;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import static org.springframework.util.Assert.notNull;

/**
 * @author qxlx
 * @date 2024/11/25 21:08
 */
public class SpringApplication {

    @Test
    public void testBfpp() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ioc.getBean(Person.class);
        notNull(person);
    }

}
