package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import com.danbro.springcloud.enumeration.CodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/5/19 20:05
 * @Author Danrbo
 */
@RestController
public class PaymentController {


    @Value("${server.port}")
    private int port;

    /**
     * 模拟数据库
     */
    private static HashMap<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L,new Payment(1L,"serialA"));
        map.put(2L,new Payment(2L,"serialB"));
        map.put(3L,new Payment(3L,"serialC"));
    }


    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult<>(CodeEnum.SUCCESS, payment);
        String message = result.getMessage();
        result.setMessage(message + "---port:" + port);
        return result;
    }
}
