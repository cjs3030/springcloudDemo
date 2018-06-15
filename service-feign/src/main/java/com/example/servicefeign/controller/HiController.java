package com.example.servicefeign.controller;

import com.example.servicefeign.service.SchedualServiceHi;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 暴露对外接口
 * Create By   Patrick Leee
 * CreateTime  2018/4/3 下午2:00
 * UpdateTime  2018/4/3 下午2:00
 */

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
