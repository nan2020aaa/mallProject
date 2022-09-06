package com.example.demo.models.ums;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsRole {
	//后台用户数量
	@Column
	private Integer adminCount;
	
	//创建时间
	@Column
	private String createTime;
	
	//描述
	@Column
	private String description;
	
	@Id
	private Long id;
	
	//名称
	@Column
	private String name;
	
	@Column
	private Integer sort;
	
	//启用状态：0->禁用；1->启用
	@Column
	private Integer status;
}
