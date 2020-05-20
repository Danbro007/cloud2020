package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/5/20 13:38
 * @Author Danrbo
 */
@FeignClient(value = "payment-service-nacos",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    CommonResult getPaymentById(@PathVariable("id")Long id);
}
