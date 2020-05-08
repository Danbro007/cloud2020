package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;




/**
 * @Classname OrderMain80
 * @Description TODO 订单启动类
 * @Date 2020/5/8 9:48
 * @Author Danrbo
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
