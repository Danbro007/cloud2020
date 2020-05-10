package com.danbro.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ApplicationContext
 * @Description TODO
 * @Date 2020/5/8 9:55
 * @Author Danrbo
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced //使用自己写的的ribbon负载均衡算法要注释掉该注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
