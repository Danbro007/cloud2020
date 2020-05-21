package com.danbro.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SetaStorageMain
 * @Description TODO
 * @Date 2020/5/21 13:34
 * @Author Danrbo
 */

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.danbro.springcloud.mapper")
public class SetaStorageMain {

    public static void main(String[] args) {
        SpringApplication.run(SetaStorageMain.class,args);
    }
}
