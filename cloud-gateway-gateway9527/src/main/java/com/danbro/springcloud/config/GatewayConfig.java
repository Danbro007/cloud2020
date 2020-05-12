package com.danbro.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GatewayConfig
 * @Description TODO 代码方式配置Gateway
 * @Date 2020/5/12 22:12
 * @Author Danrbo
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route("path_route_test", r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji"))
                .build();
    }
}
