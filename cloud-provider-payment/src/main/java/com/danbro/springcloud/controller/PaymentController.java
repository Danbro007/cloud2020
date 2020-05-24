package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import com.danbro.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentController
 * @Description TODO 支付controller
 * @Date 2020/5/7 15:25
 * @Author Danrbo
 */
@RestController
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    /**
     * 通过支付Id查询支付信息
     * @param id 支付消息的Id
     * @return 支付消息
     */
    @GetMapping("/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        System.out.println("from port:" + port);
        return paymentService.getPaymentById(id);
    }

    /**
     * 在数据库创建支付信息
     * @param payment 支付信息
     * @return 消息
     */
    @PostMapping(value = "/payment")
    public CommonResult insertPayment(@RequestBody  Payment payment) {
        return paymentService.insertPayment(payment);
    }

    @GetMapping(value = "/payment/timeout")
    public String paymentTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(port);
    }

    /**
     * 测试负载均衡
     * @return 响应请求的服务器端口
     */
    @GetMapping("/payment/lb")
    public String paymentLb(){
        return String.valueOf(port);
    }

    /**
     * 测试 zipkin 链路监控
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi，i`am payment zipkin server fall back, welcome to cqvie";
    }

}
