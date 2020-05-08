package com.danbro.springcloud.entities;

import com.danbro.springcloud.enumeration.CodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname CommonResult
 * @Description TODO 返回给前端的结果类
 * @Date 2020/5/7 15:27
 * @Author Danrbo
 */
@Data
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    /**
     * 返回代码
     */
    private int code;
    /**
     * 返回的消息
     */
    private String message;
    /**
     * 返回给前端的数据
     */
    private T data;

    public CommonResult(CodeEnum codeEnum) {
        this(codeEnum, null);
    }

    public CommonResult(CodeEnum codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        this.data = data;
    }

}
