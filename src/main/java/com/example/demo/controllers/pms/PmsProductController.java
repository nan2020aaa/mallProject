package com.example.demo.controllers.pms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

		PmsProduct data = new PmsProduct();
		BeanUtils.copyProperties(param, data);

		log.info("BeanCopy完成：{}", data);

		if (productService.create(data)) {
			log.info("DBに保存完成：{}", data);
			return new CommonResult(200, null, "OK");
		} else {
			return new CommonResult(500, null, "System Error");
		}

	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list")

	public CommonResult list(@RequestParam Long brandId, @RequestParam String keyword, @RequestParam Integer pageNum,
			@RequestParam Integer pageSize, @RequestParam Long productCategoryId, @RequestParam String productSn,
			@RequestParam Integer publishStatus, @RequestParam Integer verifyStatus) {

		List<Object> pmsProductList = new ArrayList<>();

		pmsProductList.add(productService.getByBrandId(brandId));
		pmsProductList.add(productService.getByKeywords(keyword));
		pmsProductList.add(productService.getByProductCategoryId(productCategoryId));
		pmsProductList.add(productService.getByProductSn(productSn));
		pmsProductList.add(productService.getByPublishStatus(publishStatus));
		pmsProductList.add(productService.getByVerifyStatus(verifyStatus));
		return new CommonResult(200, new CommonPage(pmsProductList, pageNum, pageSize, 1l, 1), "OK");

	}
}
