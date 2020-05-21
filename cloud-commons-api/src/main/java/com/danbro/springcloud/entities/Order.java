package com.danbro.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

/**
 * @Classname Order
 * @Description TODO
 * @Date 2020/5/21 12:07
 * @Author Danrbo
 */
@Data
@TableName(value = "t_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long productId;
    private int count;
    private BigDecimal money;
    private int status;
}
