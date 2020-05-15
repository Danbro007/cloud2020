package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Classname RabbitMqProviderMain8801
 * @Description TODO
 * @Date 2020/5/14 12:50
 * @Author Danrbo
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RabbitMqProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProviderMain8801.class,args);
    }
}
