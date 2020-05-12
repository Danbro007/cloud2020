package com.danbro.springcloud.controller;

import com.danbro.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderFeignHystrixController
 * @Description TODO
 * @Date 2020/5/12 12:16
 * @Author Danrbo
 */
@DefaultProperties(defaultFallback = "defaultGlobalHandler")
@RestController
public class OrderHystrixController {

    @Autowired
    PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentOk(id);
    }

    //执行全局默认的fallback
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentTimeout(id);
    }

    //默认全局fallback
    public String defaultGlobalHandler(){
        return "默认全局fallback";
    }

    //执行自定义的fallback
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //1.5秒钟以内执行正常的业务逻辑
    })
    @GetMapping("/consumer/payment/hystrix/timeout/custom/{id}")
    public String paymentInfoTimeoutCustom(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentTimeout(id);
    }

    //自定义的fallback
    public String paymentTimeoutHandler(@PathVariable("id") Integer id){
        return "我是消费者，因为对方系统繁忙请稍后再试。";
    }
}
