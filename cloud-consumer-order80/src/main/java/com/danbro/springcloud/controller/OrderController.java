package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/5/8 9:52
 * @Author Danrbo
 */
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://localhost:8081/payment/";

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult getOrder(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+id, CommonResult.class);
    }
    @ResponseBody
    @GetMapping(value = "/consumer/payment")
    public CommonResult insertOrder(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL, payment, CommonResult.class);
    }

}
