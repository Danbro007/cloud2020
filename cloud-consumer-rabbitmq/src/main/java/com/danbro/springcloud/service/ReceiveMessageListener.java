package com.danbro.springcloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @Classname RecieveMessageListener
 * @Description TODO
 * @Date 2020/5/14 14:24
 * @Author Danrbo
 */
@EnableBinding(Sink.class)
public class ReceiveMessageListener {
    @Value("${server.port}")
    private int port;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message) {
        String receiveMessage = message.getPayload();
        System.out.println("message:" + receiveMessage + "-----port:" + port);
    }
}
