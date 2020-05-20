package com.danbro.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.danbro.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/5/19 20:18
 * @Author Danrbo
 */
@RestController
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;


//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback",fallback = "handleException") //配置fallback
//    @SentinelResource(value = "fallback",blockHandler = "handleBlockHandler") //配置blockHandler
//    @SentinelResource(value = "fallback",fallback = "handleException",blockHandler = "handleBlockHandler") //配置blockHandler和fallback
    @SentinelResource(value = "fallback",
            fallback = "handleException",
            blockHandler = "handleBlockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})//配置blockHandler和fallback,忽略IllegalArgumentException异常。
    @GetMapping("/payment/fallback/{id}")
    public CommonResult paymentFallback(@PathVariable("id")Long id){

        CommonResult result = restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class);
        if (id == 4){
            throw new IllegalArgumentException("id的参数为非法参数");
        }else if (result.getData() == null){
            throw new NullPointerException("查询不到数据");
        }
        return result;
    }

    //paymentFallback 接口的 fallback
    public CommonResult handleException(@PathVariable("id")Long id ,Throwable e){
        CommonResult commonResult = new CommonResult();
        commonResult.setMessage("fallback处理" + e.getMessage());
        return commonResult;
    }
    //paymentFallback 接口的 blockHandler
    public CommonResult handleBlockHandler(@PathVariable("id")Long id,BlockException e){
        CommonResult commonResult = new CommonResult();
        commonResult.setMessage("BlockHandler处理" + e.getMessage());
        return commonResult;
    }
}


