package com.example.demo.models.ums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//@Data
//@Entity
//@SuperBuilder
//@NoArgsConstructor
public class UmsMenu {
	//创建时间
	//@Column
	private String createTime;
	
	//前端隐藏
	//@Column
	private Integer hidden;
	
	//前端图标
	//@Column
	private String icon;
	
	//@Id
	private Long id;
	
	//菜单级数
	//@Column
	private Integer level;
	
	//前端名称
	//@Column
	private String name;
	
	//父级ID
	//@Id
	private Long parentId;
	
	//菜单排序
	//@Column
	private Integer sort;
	
	//菜单名称
	//@Column
	private String title;
}
