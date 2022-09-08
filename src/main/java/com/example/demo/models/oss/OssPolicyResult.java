package com.example.demo.models.oss;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@Entity
public class OssPolicyResult {
	//访问身份验证中用到用户标识
	//@Id
	private String accessKeyId;
	
	//上传成功后的回调设置
	//@Column
	private String callback;
	
	//上传文件夹路径前缀
	//@Column
	private String dir;
	
	//oss对外服务的访问域名
	//@Column
	private String host;
	
	//用户表单上传的策略,经过base64编码过的字符串
	//@Column
	private String policy;
	
	//对policy签名后的字符串
	//@Column
	private String signature;

}
