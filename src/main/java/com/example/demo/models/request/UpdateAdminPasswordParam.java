package com.example.demo.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UpdateAdminPasswordParam {
	//新密码
	private String newPassword;
	
	//旧密码
	private String oldPassword;
	
	//用户名
	private String username;
}
