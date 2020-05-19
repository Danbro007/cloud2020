package com.danbro.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Payment;
import com.danbro.springcloud.enumeration.CodeEnum;
import com.danbro.springcloud.myhandler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RateLimitController
 * @Description TODO
 * @Date 2020/5/19 14:16
 * @Author Danrbo
 */
@RestController
public class RateLimitController {
    /**
     * 通过资源名访问
     */
    @SentinelResource(value = "byresource",blockHandler = "handleException")
    @GetMapping("/byresource")
    public CommonResult byResource(){
    return new CommonResult(CodeEnum.SUCCESS,new Payment(1L,"serialA"));
    }

    /**
     * /byresource 的BlockHandler方法
     */
    public CommonResult handleException(BlockException ex){
        return new CommonResult(CodeEnum.NOT_FOUND,null);
    }


    //测试自定义的 BlockHandler
    @SentinelResource(value = "testHandler1",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handler1")
    @GetMapping("/rateLimit/testHandler1")
    public CommonResult testHandler1(){
        return new CommonResult(CodeEnum.SUCCESS,new Payment(2L,"serialB"));
    }

    @SentinelResource(value = "testHandler2",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handler2")
    @GetMapping("/rateLimit/testHandler2")
    public CommonResult testHandler2(){
        return new CommonResult(CodeEnum.SUCCESS,new Payment(2L,"serialB"));
    }
}
