package com.danbro.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname NacosConsumerController
 * @Description TODO
 * @Date 2020/5/16 13:34
 * @Author Danrbo
 */
@RestController
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @GetMapping("/consumer/payment/{id}")
    public String orderNacos(@PathVariable("id") Long id) {

        return restTemplate.getForObject(SERVICE_URL + "/payment/nacos/" + id, String.class);

    }
}
