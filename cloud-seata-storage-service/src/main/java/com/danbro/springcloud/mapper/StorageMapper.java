package com.danbro.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.danbro.springcloud.entities.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname StorageMapper
 * @Description TODO
 * @Date 2020/5/21 13:41
 * @Author Danrbo
 */
public interface StorageMapper extends BaseMapper<Storage> {

    /**
     * 通过商品ID 扣除库存
     * @param productId 商品ID
     * @param count 要扣除的商品数量
     * @return
     */
    int decreaseByProductId(@Param("productId") Long productId, @Param("count") int count);
}
