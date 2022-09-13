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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.pms.PmsProductCategory;
import com.example.demo.models.pms.PmsProductCategoryWithChildrenItem;
import com.example.demo.models.request.PmsProductCategoryParam;
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

		PmsProductCategory data = new PmsProductCategory();
		BeanUtils.copyProperties(param, data);
		log.info("BeanCopy完成：{}", data);
		productCategoryService.setLevel(data);

		if (productCategoryService.create(data)) {
			log.info("DBに保存完成：{}", data);
			return new CommonResult(200, null, "OK");
		} else {
			return new CommonResult(500, null, "System Error");
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list/withChildren")
	public CommonResult listWithChildren() {
		List<PmsProductCategoryWithChildrenItem> targetList = new ArrayList<>();
		List<PmsProductCategory> dataList = productCategoryService.findAll();
		dataList.forEach((e) -> {
			PmsProductCategoryWithChildrenItem tmpInstance = new PmsProductCategoryWithChildrenItem();
			BeanUtils.copyProperties(e, tmpInstance);
			if (tmpInstance.getParentId() == 0) {
				targetList.add(tmpInstance);
			}
		});
		targetList.forEach((e) -> {
			productCategoryService.setChildrenItem(e);
		});
		return new CommonResult(200, targetList, "OK");
	}
}
