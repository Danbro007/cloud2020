package com.danbro.springcloud.controller;

import com.danbro.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PaymentHystrixController
 * @Description TODO
 * @Date 2020/5/12 10:39
 * @Author Danrbo
 */
@RestController
public class PaymentHystrixController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoTimeout(id);
    }


}
