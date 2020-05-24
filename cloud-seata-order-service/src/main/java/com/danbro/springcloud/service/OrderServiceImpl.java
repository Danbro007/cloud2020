package com.danbro.springcloud.service;

import com.danbro.springcloud.entities.Order;
import com.danbro.springcloud.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2020/5/21 12:46
 * @Author Danrbo
 */
@Log4j2
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @GlobalTransactional(name="fsp_order_service",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("--------->开始创建订单<---------");
        orderMapper.insert(order);
        log.info("--------->订单微服务开始调用库存微服务，减库存<---------");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("--------->订单微服务调用库存微服务结束<---------");
        log.info("--------->订单微服务开始调用账户微服务，更新账户信息<---------");
        accountService.update(order.getUserId(), order.getMoney());
        log.info("--------->订单微服务调用账户微服务结束<---------");
        log.info("--------->更新订单状态<---------");
        order.setStatus(1);
        orderMapper.updateById(order);
        log.info("--------->下订单服务结束<---------");
    }
}
