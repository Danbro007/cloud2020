package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname OrderMain90
 * @Description TODO
 * @Date 2020/5/19 20:19
 * @Author Danrbo
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class OrderMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain90.class,args);
    }
}
