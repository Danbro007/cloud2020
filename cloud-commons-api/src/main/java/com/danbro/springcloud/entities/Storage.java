package com.danbro.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Storage
 * @Description TODO
 * @Date 2020/5/21 12:16
 * @Author Danrbo
 */
@Data
@TableName(value = "t_storage")
public class Storage {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long productId;
    private int total;
    private int used;
    private int residue;
}
