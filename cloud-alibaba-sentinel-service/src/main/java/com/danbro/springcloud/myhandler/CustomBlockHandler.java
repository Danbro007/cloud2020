package com.danbro.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.enumeration.CodeEnum;

/**
 * @Classname CustomBlockHandler
 * @Description TODO
 * @Date 2020/5/19 16:21
 * @Author Danrbo
 */

/**
 * 自定义的BlockHandler
 */
public class CustomBlockHandler {


    public static CommonResult handler1(BlockException ex){
        return new CommonResult(CodeEnum.INVOKE_HANDLER1,null);
    }

    public static CommonResult handler2(BlockException ex){
        return new CommonResult(CodeEnum.INVOKE_HANDLER2,null);
    }
}
