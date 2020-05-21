package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.Order;
import org.springframework.stereotype.Service;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2020/5/21 12:44
 * @Author Danrbo
 */
@Service
public interface OrderService {

    /**
     * 创建订单
     *
     * @param order 接收到的订单信息
     */
    void create(Order order);

}
