package com.example.demo.controllers.pms;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	PmsProductService productService;
	
	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create") 
	public CommonResult create(@RequestBody PmsProductParam param) { // 传入参数为 RequestBody （在文档中标识为 body）
		Logger logger = LoggerFactory.getLogger(PmsProductController.class);
		logger.info("参数添加成功"+param.toString());
		productService.create(param);
		return new CommonResult(200,null,"OK");
	}
	
	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list")
	public CommonResult list(@RequestParam Long brandId, @RequestParam String keyword, @RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Long productCategoryId, @RequestParam String productSn, @RequestParam Integer publishStatus, @RequestParam Integer verifyStatus) {
		PmsProduct pmsProduct = new PmsProduct();//为了让程序不报错临时写的代码，功能实现后应删去。
		List<Object> pmsProductList = new ArrayList<>();
		pmsProductList.add(pmsProduct);//为了让程序不报错临时写的代码，功能实现后应删去。
		//pmsProductList.add(productService.getBybrandId());
		//pmsProductList.add(productService.getBybrandKeyword());
		//pmsProductList.add(productService.getBybrandProductCategoryId());
		//pmsProductList.add(productService.getBybrandProductSn());
		//pmsProductList.add(productService.getBybrandPublishStatus());
		//pmsProductList.add(productService.getBybrandVerifyStatus());
		return new CommonResult(200,new CommonPage(pmsProductList, pageNum, pageSize, 1l, 1),"OK");
	}
}
