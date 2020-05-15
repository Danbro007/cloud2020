package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;

/**
 * @Classname PaymentService
 * @Description TODO 支付接口
 * @Date 2020/5/7 15:50
 * @Author Danrbo
 */

public interface PaymentService {
    /**
     * 添加支付信息
     * @param payment 支付实例
     * @return 消息体
     */
    CommonResult insertPayment(Payment payment);

    /**
     * 通过支付Id查找到支付信息
     * @param id 支付id
     * @return 支付消息
     */
    CommonResult getPaymentById(Long id);

}
