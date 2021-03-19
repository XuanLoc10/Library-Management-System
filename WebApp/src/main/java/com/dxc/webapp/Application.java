package com.dxc.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.dxc.webapp")
@EnableFeignClients(basePackages = "com.dxc.webapp")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
