package com.danbro.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2020/5/12 14:16
 * @Author Danrbo
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentOk(Integer id) {
        return "this is PaymentFallbackService ok";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "PaymentFallbackService timeout";
    }
}
