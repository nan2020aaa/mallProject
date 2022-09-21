package com.example.demo.controllers.pms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.example.demo.models.pms.PmsProduct;
import com.example.demo.models.pms.PmsProductCategory;
import com.example.demo.models.pms.PmsProductCategoryWithChildrenItem;
import com.example.demo.models.request.PmsProductCategoryParam;
import com.example.demo.models.request.PmsProductParam;
import com.example.demo.models.response.CommonPage;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductCategoryService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/productCategory") // 所有本类中方法的请求路径都以 /product 开头
@Controller
@Slf4j
public class PmsProductCategoryController {
	@Autowired
	private PmsProductCategoryService productCategoryService;

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create")
	public CommonResult create(@RequestBody PmsProductCategoryParam param) { // 传入参数为 RequestBody （在文档中标识为 body）
		log.info("PmsProductCategoryController, /create, パラメータを受け取った：{}", param);

		PmsProductCategory data = PmsProductCategory.builder().build();
		BeanUtils.copyProperties(param, data);
		log.info("BeanCopy完成：{}", data);
		productCategoryService.setLevel(data);

		if (productCategoryService.create(data)) {
			log.info("DBに保存完成：{}", data);
			return CommonResult.builder().code(200).data(null).message("OK").build();
		} else {
			return CommonResult.builder().code(500).data(null).message("System error").build();
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list/withChildren")
	public CommonResult listWithChildren() {
		List<PmsProductCategoryWithChildrenItem> dataList = new ArrayList<>();
		log.info("------------：{}", dataList);
		List<PmsProductCategory> categoryList = productCategoryService.findAll();
		log.info("属性を引き出す：{}", categoryList);
		for (PmsProductCategory e : categoryList) {
			PmsProductCategoryWithChildrenItem tmpInstance = PmsProductCategoryWithChildrenItem.builder().build();
			BeanUtils.copyProperties(e, tmpInstance);
			if (tmpInstance.getLevel() == 0) {
				dataList.add(tmpInstance);
			}
			log.info("PmsProductCategoryWithChildrenItemのインスタンス：{}", tmpInstance);
		}
		for (PmsProductCategoryWithChildrenItem e : dataList) {
			productCategoryService.setChildrenItem(e);
		}
		log.info("secondクラス分類：{}", dataList);

		return CommonResult.builder().code(200).data(dataList).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list/{parentId}")
	public CommonResult listProductCategory(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
			@PathVariable Long parentId) {
		Pageable paging = PageRequest.of(pageNum - 1, pageSize);
		log.info("pagingというインスタンス作成、pageNum: " + pageNum + "; pageSize: " + pageSize + ".");

		Page<PmsProductCategory> categoryList = productCategoryService.findByParentId(parentId, paging);
		log.info("ページの導入完成、内容は: " + categoryList.toString() + ".");

		CommonPage commonPage = CommonPage.builder().list(categoryList.toList()).pageNum(pageNum).pageSize(pageSize)
				.total(productCategoryService.countParentId(parentId)).build();
		return CommonResult.builder().code(200).data(commonPage).message("OK").build();
	}
}
