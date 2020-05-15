package com.danbro.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/5/9 10:10
 * @Author Danrbo
 */

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public String orderToZk(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk",String.class);
    }

}
