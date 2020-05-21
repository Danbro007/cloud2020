package com.danbro.springcloud;

import com.danbro.springcloud.entities.Order;
import com.danbro.springcloud.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    OrderMapper orderMapper;

    @Test
    void test1() {
    }

    @Test
    void test2() {
        Order order = orderMapper.selectById(1L);
        System.out.println(order.getUserId());
    }

}
