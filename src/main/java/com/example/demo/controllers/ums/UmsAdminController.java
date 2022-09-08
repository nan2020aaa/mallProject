package com.example.demo.controllers.ums;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.request.UmsAdminLoginParam;
import com.example.demo.models.response.CommonResult;
import com.example.demo.util.LoginUtil;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/admin") // 所有本类中方法的请求路径都以 /admin 开头
@Controller
@Slf4j
public class UmsAdminController {

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/login") // 因为在类前注释了“@RequestMapping("/admin")”，只需要写 /admin 之后的路径
	public CommonResult login(@RequestBody UmsAdminLoginParam param) { // 传入参数为 RequestBody （在文档中标识为 body）

		Map<String, String> tokenMap = new HashMap<>();
		tokenMap.put("token", null);
		tokenMap.put("tokenHead", null);

		if (param.getPassword().equals("123") && param.getUsername().equals("abc")) {
			log.info("User {} logged in.", param.getUsername());
			return CommonResult.success(tokenMap);
		} else {
			log.warn("User {} failed to log in.",param.getUsername());
			return new CommonResult(404, null, "Fail");
		}
	}
	
	@PostMapping("role/update")
	@ResponseBody
	public CommonResult update(@RequestParam Long adminId, @RequestParam Long[] roleIds) { // 传入参数为 RequestHeader 中的 parameter （在文档中标识为 query）
		log.info("Updating user " + adminId + "'s role: " + Arrays.toString(roleIds) + ".");
		return new CommonResult(200, adminId + "'s info", "Succeed");
	}

	@GetMapping("/{id}")
	@ResponseBody
	public CommonResult info(@PathVariable Long id) { // 直接通过路径传入参数 （在文档中标识为 path）
		log.info("Getting user " + id + "'s information...");
		return new CommonResult(200, id + "'s info", "Succeed");
	}

	@PostMapping("/logout")
	@ResponseBody
	public CommonResult logout() {
		log.info("User logged out");
		return new CommonResult(200, null, "Succeed");
	}

	@GetMapping("/info")
	@ResponseBody
	public CommonResult info(Principal principal) {
		String username = "abc";
		log.info("Getting user " + username + "'s information...");
		Map<String, Object> data = new HashMap<>();
		data.put("username", username);
		data.put("menus", LoginUtil.getMenuList());
		data.put("icon", "");
		data.put("roles", LoginUtil.getRoleList());

		return CommonResult.success(data);
	}
}
