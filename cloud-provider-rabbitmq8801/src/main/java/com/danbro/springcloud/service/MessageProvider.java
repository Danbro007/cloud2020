package com.danbro.springcloud.service;

/**
 * @Classname MessageProvider
 * @Description TODO
 * @Date 2020/5/14 12:52
 * @Author Danrbo
 */

public interface MessageProvider {
    /**
     * 发送消息
     * @return 发送的消息
     */
    String sendMessage();

}
