package com.example.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description 调用其他服务
 * Create By   Patrick Leee
 * CreateTime  2018/4/3 下午1:58
 * UpdateTime  2018/4/3 下午1:58
 */
// 指定调用哪个服务，异常时的熔断处理
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
