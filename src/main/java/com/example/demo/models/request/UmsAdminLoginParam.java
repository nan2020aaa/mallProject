package com.example.demo.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsAdminLoginParam {
	//密码
	private String password;
	
	//用户名
	private String username;
	
}
