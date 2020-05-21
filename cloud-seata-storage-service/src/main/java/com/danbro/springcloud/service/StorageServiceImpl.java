package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.entities.Storage;
import com.danbro.springcloud.enumeration.CodeEnum;
import com.danbro.springcloud.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname StorageServiceImpl
 * @Description TODO
 * @Date 2020/5/21 13:42
 * @Author Danrbo
 */
@Service
public class StorageServiceImpl implements StorageService{

    @Autowired
    StorageMapper storageMapper;

    @Override
    public CommonResult decrease(Long productId, int count) {
        int i = storageMapper.decreaseByProductId(productId, count);
        if (i == 1){
            return new CommonResult(CodeEnum.SUCCESS);
        }
        return new CommonResult(CodeEnum.FAILURE);
    }
}
