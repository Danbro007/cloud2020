package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2020/5/21 12:53
 * @Author Danrbo
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 更新用户账户额度信息
     * @param userId 用户ID
     * @param money 订单总额
     * @return 返回结果
     */
    @PutMapping("/account")
    CommonResult update(@RequestParam("user_id")Long userId, @RequestParam("money")BigDecimal money);
}
