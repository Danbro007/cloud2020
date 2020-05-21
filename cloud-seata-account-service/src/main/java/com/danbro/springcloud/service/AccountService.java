package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2020/5/21 14:22
 * @Author Danrbo
 */
public interface AccountService {

    CommonResult update(Long userId, BigDecimal money);

}
