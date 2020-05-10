package com.danbro.springcloud.myloadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname RoundRobinRule
 * @Description TODO
 * @Date 2020/5/10 15:37
 * @Author Danrbo
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        //对计数器的值与服务实例的数量取余
        int nextInstanceIndex = getAndIncrement() % instances.size();
        //返回实例对象
        return instances.get(nextInstanceIndex);
    }

    @Override
    public final int getAndIncrement() {
        //对计数器加1后的数值
        int next;
        //当前计数器的数值
        int current;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE?0:current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        return next;
    }

}
