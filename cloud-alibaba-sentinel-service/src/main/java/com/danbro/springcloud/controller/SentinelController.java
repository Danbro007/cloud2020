package com.danbro.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SentinelController
 * @Description TODO
 * @Date 2020/5/18 10:37
 * @Author Danrbo
 */
@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String testA(){
        return "-----test A-----";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-----test B-----";
    }
}
