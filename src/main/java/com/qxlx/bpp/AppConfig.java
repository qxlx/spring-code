package com.qxlx.bpp;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author qxlx
 * @date 2024/12/3 22:11
 */
@Configuration
@ComponentScan("com.qxlx.bpp")
@EnableAspectJAutoProxy
public class AppConfig {

}
