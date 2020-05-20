package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname OrderMain90
 * @Description TODO
 * @Date 2020/5/20 13:36
 * @Author Danrbo
 */
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class OrderFeignSentinelMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignSentinelMain90.class,args);
    }
}


