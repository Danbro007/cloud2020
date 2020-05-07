package com.danbro.springcloud.enumeration;

/**
 * @Classname CodeEnum
 * @Description TODO
 * @Date 2020/5/7 15:31
 * @Author Danrbo
 */
public enum CodeEnum {
    /**
     * 发送是否成功
     */
    Success(200, "发送成功"),
    NOT_FOUND(404, "发送失败");



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
