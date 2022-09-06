package com.example.demo.models.ums;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsResource {
	//资源分类ID
	@Id
	private Long categoryId;
	
	//创建时间
	@Column
	private String createTime;
	
	//描述
	@Column
	private String description;
	
	@Id
	private Long id;
	
	//资源名称
	@Column
	private String name;
	
	//资源URL
	@Column
	private String url;
}
