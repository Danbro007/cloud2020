package com.danbro.springcloud.controller;

import com.danbro.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RabbitMqController
 * @Description TODO
 * @Date 2020/5/14 13:08
 * @Author Danrbo
 */
@RestController
public class RabbitMqController {
    @Autowired
    MessageProvider messageProvider;


    @GetMapping("/rabbit/send")
    public String sendMessage() {
        return messageProvider.sendMessage();
    }
}
