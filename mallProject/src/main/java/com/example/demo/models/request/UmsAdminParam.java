package com.example.demo.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsAdminParam {
	//邮箱
	private String email;
	
	//用户头像
	private String icon;
	
	//用户昵称
	private String nickName;
	
	//备注
	private String note;
	
	//密码
	private String password;
	
	//用户名
	private String username;
}
