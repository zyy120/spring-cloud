package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.springcloud.entities.Dept;

@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
//一旦调用后服务器失败抛出错误信息后，会自动调用@HystrixCommand中指定fallbackMethod方法。
public interface DeptClientService {

	@RequestMapping(value="/dept/get/{id}",method =RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);
	
	@RequestMapping(value="/dept/list",method =RequestMethod.GET)
	public List<Dept> list();
	
	@RequestMapping(value="/dept/add",method =RequestMethod.POST)
	public boolean add(Dept dept);
}
