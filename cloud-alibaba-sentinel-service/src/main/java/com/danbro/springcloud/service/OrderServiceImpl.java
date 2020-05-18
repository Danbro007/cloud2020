package com.danbro.springcloud.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    @SentinelResource("getOrder")
    @Override
    public String getOrder() {
        return "order";
    }
}
