package com.example.demo.controllers.pms;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
		log.info("paramの内容は：" + param + ".");
		BeanUtils.copyProperties(param, data);
		log.info("dataの内容は：" + data + ".");
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
	public CommonResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
			@RequestParam(required = false) Long brandId, @RequestParam(required = false) String keyword,
			@RequestParam(required = false) Long productCategoryId, @RequestParam(required = false) String productSn,
			@RequestParam(required = false) Integer publishStatus,
			@RequestParam(required = false) Integer verifyStatus) {

		Pageable paging = PageRequest.of(pageNum - 1, pageSize);
		log.info("pagingというインスタンス作成、pageNum: " + pageNum + "; pageSize: " + pageSize + ".");

		PmsProduct product = PmsProduct.builder().name(keyword).brandId(brandId).productCategoryId(productCategoryId)
				.productSn(productSn).verifyStatus(verifyStatus).publishStatus(publishStatus).build();

		// 用example matching的方法查询，大小写自由，包含关系
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", match -> match.ignoreCase().contains());

		Example<PmsProduct> example = Example.of(product, matcher);
		// 查找并返回页数
		Page<PmsProduct> products = productService.findAll(example, paging);
		log.info("ページの導入完成、内容は: " + products.toList().toString() + ".");

		CommonPage commonPage = CommonPage.builder().list(products.toList()).pageNum(pageNum).pageSize(pageSize)
				.total(products.getTotalElements()).totalPage(productService.getTotalPageDependsOnContent(pageSize))
				.build();

		return CommonResult.builder().code(200).data(commonPage).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/update/deleteStatus")
	public CommonResult deleteStatus(@RequestParam Integer deleteStatus, @RequestParam List<Long> ids) {
		productService.delete(ids);
		return CommonResult.builder().code(200).data(null).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/update/publishStatus")
	public CommonResult publishStatus(@RequestParam List<Long> ids, @RequestParam Integer publishStatus) {
		productService.updatePublishStatus(ids, publishStatus);
		return CommonResult.builder().code(200).data(null).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/update/newStatus")
	public CommonResult newStatus(@RequestParam List<Long> ids, @RequestParam Integer newStatus) {
		productService.updateNewStatus(ids, newStatus);
		return CommonResult.builder().code(200).data(null).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/update/recommendStatus")
	public CommonResult recommendStatus(@RequestParam List<Long> ids, @RequestParam Integer recommendStatus) {
		productService.updateRecommendStatus(ids, recommendStatus);
		return CommonResult.builder().code(200).data(null).message("OK").build();
	}
}