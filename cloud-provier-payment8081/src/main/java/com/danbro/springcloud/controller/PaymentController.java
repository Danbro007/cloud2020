package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import com.danbro.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/5/7 15:25
 * @Author Danrbo
 */
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/payment")
    public CommonResult insertPayment(Payment payment) {
        return paymentService.insertPayment(payment);
    }


    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

}
