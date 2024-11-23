package com.qxlx.springmybatis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author qxlx
 * @date 2024/11/21 21:59
 */
@Configuration
@ComponentScan("com.qxlx.springmybatis")
@Import(MyImportRegister.class)
public class AppConfig {
}
