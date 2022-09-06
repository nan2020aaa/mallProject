package com.example.demo.models.ums;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsResourceCategory {
	//创建时间
	@Column
	private String createTime;
	
	@Id
	private Long id;
	
	//分类名称
	@Column
	private String name;
	
	//排序
	@Column
	private Integer sort;
}
