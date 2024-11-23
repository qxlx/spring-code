package com.qxlx.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author qxlx
 * @date 2024/11/18 21:56
 */
@Configuration
@ComponentScan(basePackages = "com.qxlx.application")
//@Import(Person.class)
@Import(MyImportSelector.class)
public class AppConfig {

}
