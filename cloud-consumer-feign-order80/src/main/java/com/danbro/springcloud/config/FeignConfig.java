package com.danbro.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Feign的日志级别
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignloggerlevel(){
        return Logger.Level.FULL;
    }
}
