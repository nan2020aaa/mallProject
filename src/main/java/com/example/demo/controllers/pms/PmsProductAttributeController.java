package com.example.demo.controllers.pms;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.pms.PmsProductAttribute;
import com.example.demo.models.request.PmsProductAttributeParam;
import com.example.demo.models.response.CommonPage;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductAttributeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/productAttribute")
@Slf4j
public class PmsProductAttributeController {
	@Autowired
	PmsProductAttributeService productAttributeService;

	@ResponseBody
	@PostMapping("/create")
	public CommonResult create(@RequestBody PmsProductAttributeParam param)
			throws IllegalAccessException, InvocationTargetException {
		PmsProductAttribute data = PmsProductAttribute.builder().build();
		log.info("paramの内容は：" + param + ".");
		BeanUtils.copyProperties(param, data);
		log.info("dataの内容は：" + data + ".");
		if (productAttributeService.create(data)) {
			return CommonResult.builder().code(200).data(null).message("OK").build();
		} else {
			return CommonResult.builder().code(500).data(null).message("System error").build();
		}
	}

	@ResponseBody
	@GetMapping("/list/{cid}")
	public CommonResult listByCid(@PathVariable Long cid, @RequestParam Integer pageNum, @RequestParam Integer pageSize,
			@RequestParam Integer type) {
		Pageable paging = PageRequest.of(pageNum - 1, pageSize);
		log.info("届いだcidは：" + cid + ".");
		List<PmsProductAttribute> list = productAttributeService.findByProductAttributeCategoryId(cid);
		List<PmsProductAttribute> attributeList = new ArrayList<>();
		List<PmsProductAttribute> parameterList = new ArrayList<>();

		list.forEach((e) -> {
			if (e.getType() == 0) {
				attributeList.add(e);
			} else {
				parameterList.add(e);
			}
		});
		log.info("商品属性の分類.属性の配列は:　" + attributeList.toString() + "；パラメタの配列は：　" + parameterList.toString()
				+ "; 取得した全部のレコードの配列：　" + list.toString() + ".");
		Page<PmsProductAttribute> attributePage = new PageImpl<>(attributeList, paging,
				productAttributeService.countByType(0));
		Page<PmsProductAttribute> parameterPage = new PageImpl<>(parameterList, paging,
				productAttributeService.countByType(1));
		if (type == 0) {
			CommonPage commonPage1 = CommonPage.builder().list(attributePage.toList()).pageNum(pageNum)
					.pageSize(pageSize).total(productAttributeService.countByType(0))
					.totalPage(productAttributeService.getTotalPageDependsOnContent(0, pageSize)).build();
			return CommonResult.builder().code(200).data(commonPage1).message("OK").build();
		} else {
			CommonPage commonPage2 = CommonPage.builder().list(parameterPage.toList()).pageNum(pageNum)
					.pageSize(pageSize).total(productAttributeService.countByType(1))
					.totalPage(productAttributeService.getTotalPageDependsOnContent(1, pageSize)).build();
			return CommonResult.builder().code(200).data(commonPage2).message("OK").build();
		}
	}
}
