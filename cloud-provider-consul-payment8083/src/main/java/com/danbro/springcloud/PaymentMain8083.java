package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname PaymentMain8083
 * @Description TODO
 * @Date 2020/5/9 18:50
 * @Author Danrbo
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PaymentMain8083 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8083.class,args);
    }
}
