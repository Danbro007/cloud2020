package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Order;
import com.danbro.springcloud.enumeration.CodeEnum;
import com.danbro.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SeataOrderController
 * @Description TODO
 * @Date 2020/5/21 12:23
 * @Author Danrbo
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public CommonResult createOrder(@RequestBody Order order){
        orderService.create(order);
        return new CommonResult(CodeEnum.SUCCESS,order);
    }
}
