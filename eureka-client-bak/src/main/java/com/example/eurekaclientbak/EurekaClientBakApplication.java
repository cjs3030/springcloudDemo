package com.example.eurekaclientbak;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientBakApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientBakApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi ".concat(name).concat(", I am from port: ").concat(port);
	}
}
