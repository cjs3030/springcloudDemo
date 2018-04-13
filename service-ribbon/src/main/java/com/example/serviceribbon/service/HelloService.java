package com.example.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Description
 * Create By   Patrick Leee
 * CreateTime  2018/4/2 上午10:50
 * UpdateTime  2018/4/2 上午10:50
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {

        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }
}
