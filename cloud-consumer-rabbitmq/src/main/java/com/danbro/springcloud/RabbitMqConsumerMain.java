package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Classname RabbitMqConsumerMain
 * @Description TODO
 * @Date 2020/5/14 14:22
 * @Author Danrbo
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RabbitMqConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerMain.class,args);
    }
}
