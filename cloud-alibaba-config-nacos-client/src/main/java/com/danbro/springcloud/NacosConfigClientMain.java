package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname NacosConfigClientMain
 * @Description TODO
 * @Date 2020/5/17 14:13
 * @Author Danrbo
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class NacosConfigClientMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain.class,args);
    }
}
