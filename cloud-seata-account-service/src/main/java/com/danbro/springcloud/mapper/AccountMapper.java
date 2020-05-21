package com.danbro.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.danbro.springcloud.entities.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Classname AccountMapper
 * @Description TODO
 * @Date 2020/5/21 14:23
 * @Author Danrbo
 */
public interface AccountMapper extends BaseMapper<Account> {

    int updateByUserId(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
