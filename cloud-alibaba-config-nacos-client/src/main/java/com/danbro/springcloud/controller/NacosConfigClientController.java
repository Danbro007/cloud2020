package com.danbro.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname NacosConfigClientController
 * @Description TODO
 * @Date 2020/5/17 14:12
 * @Author Danrbo
 */
@RestController
@RefreshScope //支持Nacos的自动刷新
public class NacosConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
