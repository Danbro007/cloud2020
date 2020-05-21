package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;

/**
 * @Classname StorageService
 * @Description TODO
 * @Date 2020/5/21 13:40
 * @Author Danrbo
 */
public interface StorageService {

    CommonResult decrease(Long productId,int count);

}
