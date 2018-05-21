package com.atguigu.springcloud.cfgbeans;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced //spring cloud roobon 是 基于ribbon实现的客服端 ， 开启负载均衡注解
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule(){
//		return new RoundRobinRule();//达到目的的，用我们重新选择的随机算法替代我们默认的沦陷ribbon 访问算法
		return new RandomRule();//随机
	}
}
