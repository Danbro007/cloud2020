package com.danbro.springcloud.ServiceImpl;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import com.danbro.springcloud.enumeration.CodeEnum;
import com.danbro.springcloud.mapper.PaymentMapper;
import com.danbro.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Classname PaymentService
 * @Description TODO 支付服务实现
 * @Date 2020/5/7 15:49
 * @Author Danrbo
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public CommonResult insertPayment(Payment payment) {

        int result = paymentMapper.insert(payment);
        if (result == 1) {
            return new CommonResult<>(CodeEnum.Success, payment);
        }
        return new CommonResult(CodeEnum.NOT_FOUND);
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        Payment payment = paymentMapper.selectById(id);
        boolean flag = Optional.ofNullable(payment).isPresent();
        if(flag){
            return new CommonResult<>(CodeEnum.Success, payment);
        }
        return new CommonResult(CodeEnum.NOT_FOUND);
    }
}
