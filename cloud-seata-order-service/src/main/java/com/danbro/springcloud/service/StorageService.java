package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname StorageService
 * @Description TODO
 * @Date 2020/5/21 12:40
 * @Author Danrbo
 */

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 通过商品ID 扣除指定指定商品的库存
     * @param productId 商品ID
     * @param count 商品数量
     * @return 返回结果
     */
    @PutMapping("/storage")
    CommonResult decrease(@RequestParam("product_id") Long productId, @RequestParam("count") int count);

}
