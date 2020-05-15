package com.danbro.springcloud.service.impl;

import com.danbro.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Classname RabbitMessageProviderImpl
 * @Description TODO
 * @Date 2020/5/14 12:53
 * @Author Danrbo
 */
@EnableBinding(Source.class) // 生产者
public class RabbitMessageProviderImpl implements MessageProvider {
    @Autowired
    private MessageChannel output;

    @Override
    public String sendMessage() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("uuid:" + uuid);
        return uuid;
    }
}
