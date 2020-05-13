package com.danbro.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Classname MyLogGatewayFilter
 * @Description TODO
 * @Date 2020/5/13 14:31
 * @Author Danrbo
 */
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("*********MyLogGatewayFilter:" + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null){
            System.out.println("username 为 null ，非法用户。");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        System.out.println("登录成功");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
