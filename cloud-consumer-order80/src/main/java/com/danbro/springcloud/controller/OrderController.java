package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/5/8 9:52
 * @Author Danrbo
 */
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult getOrder(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, CommonResult.class);
    }

    @ResponseBody
    @GetMapping(value = "/consumer/payment")
    public CommonResult insertOrder(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "payment", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment-info")
    public Object getPaymentInfo() {
        HashMap<String, Object> map = new HashMap<>(16);
        //获取所有服务
        List<String> services = discoveryClient.getServices();
        map.put("services", services);
        //获取CLOUD-PAYMENT-SERVICE的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        HashMap<String, Object> instanceHashMap = new HashMap<>(16);
        instances.forEach(i -> instanceHashMap.put(i.getInstanceId(), i.getHost() + ":" + i.getPort()));
        map.put("instances", instanceHashMap);
        return map;
    }
}
