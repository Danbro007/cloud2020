package com.danbro.springcloud.myloadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBalancer
 * @Description TODO 负载均衡器接口
 * @Date 2020/5/10 15:38
 * @Author Danrbo
 */
public interface LoadBalancer {
    /**
     * 获取下一次接收请求的服务实例
     * @param instances 服务实例列表
     * @return 下一次接收请求的服务实例
     */
    ServiceInstance getServiceInstance(List<ServiceInstance> instances);

    /**
     * 对计数的值进行cas加1
     * @return 新的数字
     */
    int getAndIncrement();
}
