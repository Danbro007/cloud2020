package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.enumeration.CodeEnum;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentServiceImpl
 * @Description TODO
 * @Date 2020/5/20 13:43
 * @Author Danrbo
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return new CommonResult(CodeEnum.NOT_FOUND);
    }
}
