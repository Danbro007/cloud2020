package com.danbro.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyRule
 * @Description TODO 修改Ribbin负载均衡的算法为随机算法
 * @Date 2020/5/10 11:06
 * @Author Danrbo
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule getMyRule(){
        return new RandomRule();
    }
}
