package com.danbro.springcloud.enumeration;

/**
 * @Classname CodeEnum
 * @Description TODO 状态码和消息枚举类
 * @Date 2020/5/7 15:31
 * @Author Danrbo
 */
public enum CodeEnum {
    /**
     * 返回代码和消息
     */
    SUCCESS(200, "发送成功"),
    NOT_FOUND(404, "发送失败"),
    INVOKE_HANDLER1(201,"调用handler1"),
    INVOKE_HANDLER2(202,"调用handler2");

    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    CodeEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }
}
