package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import com.danbro.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PaymentController
 * @Description TODO 支付controller
 * @Date 2020/5/7 15:25
 * @Author Danrbo
 */
@RestController
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    /**
     * 通过支付Id查询支付信息
     * @param id 支付消息的Id
     * @return 支付消息
     */
    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    /**
     * 在数据库创建支付信息
     * @param payment 支付信息
     * @return 消息
     */
    @PostMapping(value = "/payment")
    public CommonResult insertPayment(@RequestBody Payment payment) {
        return paymentService.insertPayment(payment);
    }

}
