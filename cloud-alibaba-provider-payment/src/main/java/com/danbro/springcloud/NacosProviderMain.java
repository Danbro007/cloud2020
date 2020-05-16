package com.danbro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname NacosProviderMain
 * @Description TODO
 * @Date 2020/5/16 13:57
 * @Author Danrbo
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NacosProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain.class,args);
    }
}