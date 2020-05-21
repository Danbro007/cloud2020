package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Classname AccountController
 * @Description TODO
 * @Date 2020/5/21 14:20
 * @Author Danrbo
 */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PutMapping("/account")
    public CommonResult update(@RequestParam("user_id")Long userId,
                               @RequestParam("money")BigDecimal money){
        return accountService.update(userId,money);
    }
}
