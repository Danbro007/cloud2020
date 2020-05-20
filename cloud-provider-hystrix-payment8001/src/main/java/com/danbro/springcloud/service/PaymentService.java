package com.danbro.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/5/12 10:27
 * @Author Danrbo
 */
@Service
public class PaymentService {
    /**
     * 请求成功
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "---->Payment Info OK------->" + id;
    }

    /**
     * 请求超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内执行正常的业务逻辑
    })
    public String paymentInfoTimeout(Integer id) {
//        int i = localhost;//模拟产生异常
        int sleepTime = 5;//模拟服务超时
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "---->Payment Info Timeout------->" + id + "----->耗时：" + sleepTime + "秒";
    }


    public String paymentTimeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "---->Payment Info Timeout 系统繁忙稍后再试------->" + id;
    }



    /*服务熔断*/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    //fallback
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
