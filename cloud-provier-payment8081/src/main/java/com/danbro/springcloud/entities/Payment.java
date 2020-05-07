package com.danbro.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Payment
 * @Description TODO
 * @Date 2020/5/7 15:26
 * @Author Danrbo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String serial;
}
