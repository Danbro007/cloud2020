package com.danbro.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SetaAccountMain
 * @Description TODO
 * @Date 2020/5/21 14:31
 * @Author Danrbo
 */
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan(basePackages = "com.danbro.springcloud.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SetaAccountMain {
    public static void main(String[] args) {
        SpringApplication.run(SetaAccountMain.class,args);
    }
}
