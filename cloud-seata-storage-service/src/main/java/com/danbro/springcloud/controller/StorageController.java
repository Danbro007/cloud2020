package com.danbro.springcloud.controller;

import com.danbro.springcloud.entities.CommonResult;
import com.danbro.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname StorageController
 * @Description TODO
 * @Date 2020/5/21 13:32
 * @Author Danrbo
 */
@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    @PutMapping("/storage")
    public CommonResult decrease(@RequestParam("product_id") Long productId, @RequestParam("count") int count){
        return storageService.decrease(productId,count);
    }
}
