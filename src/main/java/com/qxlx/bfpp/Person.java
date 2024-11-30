package com.qxlx.bfpp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qxlx
 * @date 2024/11/25 21:07
 */
@Component
public class Person {

    @Value("${userId}")
    private Integer userId;

    @Value("${name}")
    private String name;
}
