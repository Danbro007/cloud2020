package com.danbro.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname NacosProviderController
 * @Description TODO
 * @Date 2020/5/16 13:57
 * @Author Danrbo
 */
@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/payment/nacos/{id}")
    public String paymentNacos(@PathVariable("id") Long id) {
        return "Nacos registry, serverPort: " + port + "\tid " + id;
    }
}
