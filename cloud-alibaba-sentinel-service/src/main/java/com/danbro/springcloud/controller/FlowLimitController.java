package com.danbro.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Classname SentinelController
 * @Description TODO
 * @Date 2020/5/18 10:37
 * @Author Danrbo
 */
@RestController
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() {
        return "-----test A-----";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println(Thread.currentThread().getName());
        return "-----test B-----";
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-----test 平均响应时间RT-----";
    }


    @GetMapping("/testD")
    public String testD() {
        int i = 2 / 0;
        return "-----test 异常比例-----";
    }

    @GetMapping("/testE")
    public String testE() {
        int i = 2 / 0;
        return "-----test 异常数-----";
    }


    @SentinelResource(value = "testKey", blockHandler = "handleTestHotKey")
    @GetMapping("/testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int i = 2 / 0;
        return "test HotKey Success!";
    }

    /**
     * testHotKey 的兜底降级方法
     */
    public String handleTestHotKey(String p1, String p2, BlockException ex) {
        return "handle testHotKey";
    }
}
