package com.danbro.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname Payment8081Main
 * @Description TODO
 * @Date 2020/5/7 14:29
 * @Author Danrbo
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.danbro.springcloud.mapper")
public class PaymentMain8081 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8081.class,args);
    }
}
