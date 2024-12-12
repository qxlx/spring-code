package com.qxlx.aopprocessor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qxlx
 * @date 2024/12/8 16:04
 */
@Configuration
@ComponentScan("com.qxlx.aopprocessor")
@MyEnableAspectjAutoProxy
public class Config {

}
