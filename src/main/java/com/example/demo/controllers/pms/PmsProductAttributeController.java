package com.example.demo.controllers.pms;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.pms.PmsProductAttribute;
import com.example.demo.models.request.PmsProductAttributeParam;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductAttributeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/productAtrribute")
@Slf4j
public class PmsProductAttributeController {
	@Autowired
	PmsProductAttributeService productAttributeService;

	@ResponseBody
	@PostMapping("/create")
	public CommonResult create(@RequestBody PmsProductAttributeParam param)
			throws IllegalAccessException, InvocationTargetException {
		PmsProductAttribute data = PmsProductAttribute.builder().build();
		BeanUtils.copyProperties(param, data);
		if (productAttributeService.create(data)) {
			return CommonResult.builder().code(200).data(null).message("OK").build();
		} else {
			return CommonResult.builder().code(500).data(null).message("System error").build();
		}
	}
}
