package com.qxlx.bfpp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qxlx
 * @date 2024/11/25 21:07
 */
@Configuration
@ComponentScan("com.qxlx.bfpp")
@PropertySource("classpath:app.properties")
public class AppConfig {

}
