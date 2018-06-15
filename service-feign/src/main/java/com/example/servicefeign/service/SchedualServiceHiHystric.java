package com.example.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * Description 异常时，熔断处理
 * Create By   Patrick Leee
 * CreateTime  2018/4/3 下午2:40
 * UpdateTime  2018/4/3 下午2:40
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry".concat(name);
    }
}
