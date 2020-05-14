package com.danbro.springcloud.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/5/9 9:46
 * @Author Danrbo
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String paymentToZk() {
        return "SpringCloud ZooKeeper port" + port + "  " + UUID.randomUUID();
    }
}
