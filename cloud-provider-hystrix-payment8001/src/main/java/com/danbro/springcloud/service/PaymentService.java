package com.danbro.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
//        int i = 2/0;//模拟产生异常
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
}
