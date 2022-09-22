package com.example.demo.controllers.pms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.pms.PmsProductAttributeCategory;
import com.example.demo.models.pms.PmsProductAttributeCategoryItem;
import com.example.demo.models.response.CommonPage;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductAttributeCategoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/productAttribute/category")
@Slf4j
public class PmsProductAttributeCategoryController {
	@Autowired
	PmsProductAttributeCategoryService productAttributeCategoryService;

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create")
	public CommonResult create(@RequestParam String name) {
		PmsProductAttributeCategory pmsProductAttributeCategory = PmsProductAttributeCategory.builder().build();
		pmsProductAttributeCategory.setName(name);
		if (productAttributeCategoryService.create(pmsProductAttributeCategory)) {
			return CommonResult.builder().code(200).data(null).message("OK").build();
		} else {
			return CommonResult.builder().code(500).data(null).message("System error").build();
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list")
	public CommonResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
		Pageable paging = PageRequest.of(pageNum - 1, pageSize);
		log.info("pagingというインスタンス作成、pageNum: " + pageNum + "; pageSize: " + pageSize + ".");

		Page<PmsProductAttributeCategory> pmsProductAttributeCategoryPage = productAttributeCategoryService
				.findAll(paging);
		log.info("ページの導入完成、内容は: " + pmsProductAttributeCategoryPage.toString() + ".");

		CommonPage commonPage = CommonPage.builder().list(pmsProductAttributeCategoryPage.toList()).pageNum(pageNum)
				.pageSize(pageSize).total(productAttributeCategoryService.countAll())
				.totalPage(productAttributeCategoryService.getTotalPageDependsOnContent(pageSize)).build();
		return CommonResult.builder().code(200).data(commonPage).message("OK").build();
	}
}
