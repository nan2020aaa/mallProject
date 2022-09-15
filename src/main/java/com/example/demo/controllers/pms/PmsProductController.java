package com.example.demo.controllers.pms;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.pms.PmsProduct;
import com.example.demo.models.request.PmsProductParam;
import com.example.demo.models.response.CommonPage;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/product") // 所有本类中方法的请求路径都以 /product 开头
@Controller
@Slf4j
public class PmsProductController {

	@Autowired
	private PmsProductService productService;

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create")
	public CommonResult create(@RequestBody PmsProductParam param) { // 传入参数为 RequestBody （在文档中标识为 body）

		log.info("PmsProductController, /create, パラメータを受け取った：{}", param);

		PmsProduct data = PmsProduct.builder().build();
		BeanUtils.copyProperties(param, data);
		log.info("BeanCopy完成：{}", data);

		if (productService.create(data)) {
			log.info("DBに保存完成：{}", data);
			return CommonResult.builder().code(200).data(null).message("OK").build();
		} else {
			return CommonResult.builder().code(500).data(null).message("System error").build();
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list")
	public CommonResult list(
			/* @RequestParam Long brandId, @RequestParam String keyword, */@RequestParam Integer pageNum,
			@RequestParam Integer pageSize/*
											 * , @RequestParam Long productCategoryId, @RequestParam String productSn,
											 * 
											 * @RequestParam Integer publishStatus, @RequestParam Integer verifyStatus
											 */) {

//		List<Object> pmsProductList = new ArrayList<>();
//
//		pmsProductList.add(productService.getByBrandId(brandId));
//		pmsProductList.add(productService.getByKeywords(keyword));
//		pmsProductList.add(productService.getByProductCategoryId(productCategoryId));
//		pmsProductList.add(productService.getByProductSn(productSn));
//		pmsProductList.add(productService.getByPublishStatus(publishStatus));
//		pmsProductList.add(productService.getByVerifyStatus(verifyStatus));

		Pageable paging = PageRequest.of(pageNum - 1, pageSize);
		log.info("pagingというインスタンス作成、pageNum: " + pageNum + "; pageSize: " + pageSize + ".");

		Page<PmsProduct> pmsProductPage = productService.findAll(paging);
		log.info("ページの導入完成、内容は: " + pmsProductPage.toString() + ".");

		CommonPage commonPage = CommonPage.builder().list(pmsProductPage.toList()).pageNum(pageNum).pageSize(pageSize)
				.total(productService.countAll()).totalPage(productService.getTotalPageDependsOnContent(pageSize))
				.build();
		return CommonResult.builder().code(200).data(commonPage).message("OK").build();
	}
}