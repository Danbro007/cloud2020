package com.danbro.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname Payment8081Main
 * @Description TODO
 * @Date 2020/5/7 14:29
 * @Author Danrbo
 */
@SpringBootApplication
@MapperScan(basePackages = "com.danbro.springcloud.mapper")
public class Payment8081Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8081Main.class,args);
    }
}
