package com.example.demo.controllers.pms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.request.PmsProductParam;
import com.example.demo.models.response.CommonResult;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/product") // 所有本类中方法的请求路径都以 /product 开头
@Controller
@Slf4j
public class PmsProductController {
	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create") // 因为在类前注释了“@RequestMapping("/admin")”，只需要写 /admin 之后的路径
	public CommonResult create(@RequestBody PmsProductParam param) { // 传入参数为 RequestBody （在文档中标识为 body）
		Map<String, String> tokenMap =new HashMap<>();
		
		
		return new CommonResult(200,null,"good");
	}
}
