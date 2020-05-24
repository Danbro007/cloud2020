package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/5/10 20:04
 * @Author Danrbo
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {
    @GetMapping(value = "/payment/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    String paymentTimeout();

    @GetMapping("/payment/zipkin")
    String paymentZipkin();
}
