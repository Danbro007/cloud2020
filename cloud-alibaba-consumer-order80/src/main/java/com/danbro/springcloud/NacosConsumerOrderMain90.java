package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname NacosOrderMain90
 * @Description TODO
 * @Date 2020/5/16 13:30
 * @Author Danrbo
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class NacosConsumerOrderMain90 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrderMain90.class,args);
    }
}
