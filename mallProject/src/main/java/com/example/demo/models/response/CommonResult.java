package com.example.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//创建 API 中规定的 response 所具有的类型
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResult {

	private long code;
	private Object data;
	private String message;

	public static CommonResult success(Object data) {
		return CommonResult.builder().code(200l).data(data).message("通信成功").build();
	}

}
