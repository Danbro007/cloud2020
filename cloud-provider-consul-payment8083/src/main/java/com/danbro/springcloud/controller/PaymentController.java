package com.danbro.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/5/9 18:50
 * @Author Danrbo
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private int port;


    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud consul port:" + port + "---->" + UUID.randomUUID();
    }




}
