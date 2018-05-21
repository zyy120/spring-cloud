package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//@AllArgsConstructor //所有构造函数
@SuppressWarnings("serial")
@NoArgsConstructor//空参数构造函数
@Data//构造数据
@Accessors(chain=true)//链式风格访问
public class Dept implements Serializable{
	private Long 	deptno; // 主键
	private String 	dname; // 部门名称
	private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	public Dept(String dname)
	{
		super();
		this.dname = dname;
	}
}
