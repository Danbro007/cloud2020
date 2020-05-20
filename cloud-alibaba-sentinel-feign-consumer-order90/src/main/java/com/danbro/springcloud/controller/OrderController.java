package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/5/20 13:36
 * @Author Danrbo
 */
@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/openfeign/payment/{id}")
    public CommonResult getPaymentFeign(@PathVariable("id") Long id) {

        return paymentService.getPaymentById(id);
    }


}
