package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.enumeration.CodeEnum;
import com.danbro.springcloud.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Classname AccountServiceImpl
 * @Description TODO
 * @Date 2020/5/21 14:28
 * @Author Danrbo
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public CommonResult update(Long userId, BigDecimal money) {
        int i = accountMapper.updateByUserId(userId, money);
        if (i == 1){
            return new CommonResult(CodeEnum.SUCCESS);
        }
        return new CommonResult(CodeEnum.FAILURE);
    }
}
