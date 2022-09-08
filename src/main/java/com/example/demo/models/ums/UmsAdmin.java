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
public class UmsAdmin {
	//创建时间
	//@Column
	private String createTime;
	
	//邮箱
	//@Column
	private String email;
	
	//头像
	//@Column
	private String icon;
	
	//@Id
	private Long id;
	
	//最后登录时间
	//@Column
	private String loginTime;
	
	//昵称
	//@Column
	private String nickName;
	
	//备注信息
	//@Column
	private String note;
	
	//@Column
	private String password;
	
	//账号启用状态：0->禁用；1->启用
	//@Column
	private Integer status;
	
	//@Column
	private String username;
}
