package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;

@SpringBootApplication
//@EnableDiscoveryClient 
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)//开启MICROSERVICECLOUD-DEPT 服务器@RibbonClient规则
public class DeptConsumer80_App {

	public static void main(String[] args) {

		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
