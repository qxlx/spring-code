package com.qxlx.configuration;

import com.qxlx.application.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qxlx
 * @date 2024/12/1 12:06
 */
@Configuration
@ComponentScan("com.qxlx.configuration")
public class AppConfig {

    @Bean
    public User user(){
        return new User();
    }

}
