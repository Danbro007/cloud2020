package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;

/**
 * @Classname PaymentService
 * @Description TODO 支付服务接口
 * @Date 2020/5/7 15:50
 * @Author Danrbo
 */

public interface PaymentService {

    CommonResult insertPayment(Payment payment);

    CommonResult getPaymentById(Long id);

}
