package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname PaymentMain8082
 * @Description TODO
 * @Date 2020/5/9 9:47
 * @Author Danrbo
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PaymentMain8082 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8082.class,args);
    }
}
