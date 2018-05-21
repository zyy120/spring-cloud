package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	
	@Autowired
	private DeptService service;
	

	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	//一旦调用后服务器失败抛出错误信息后，会自动调用@HystrixCommand中指定fallbackMethod方法。
	public Dept get(@PathVariable("id") Long id) {
		Dept dept=service.get(id);
		if (dept ==null) {
			throw new RuntimeException("改id没有用户信息"+id);
		}
		return dept;
	}
	
	public Dept processHystrix_Get(@PathVariable("id") Long id){
		return new Dept().setDeptno(id).setDname("this is id"+id+"not info null #@HystrixCommand")
				.setDb_source("not this datebase in mysql");
	}
}
