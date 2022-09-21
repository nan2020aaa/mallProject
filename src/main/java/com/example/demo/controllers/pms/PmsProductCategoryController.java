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

@RequestMapping("/productCategory") // 所有本类中方法的请求路径都以 /productCategory 开头
@Controller
@Slf4j
public class PmsProductCategoryController<PmsProductCategoryList> {

	@Autowired
	private PmsProductCategoryService productCategoryService;

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create")
	public CommonResult create(@RequestBody PmsProductCategoryParam param) { // 传入参数为 RequestBody （在文档中标识为 body）
		PmsProductCategory data = new PmsProductCategory();
		BeanUtils.copyProperties(param, data);
		productCategoryService.setLevel(data);

		if (productCategoryService.create(data)) {

			return new CommonResult(200, null, "OK");
		} else {
			return new CommonResult(500, null, "System Error");
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list/withChildren")
	public CommonResult listwithChildren() {

		List<PmsProductCategoryWithChildrenItem> dataList = new ArrayList<>();
		log.info("------------------------------------:{}", dataList);
		List<PmsProductCategory> categoryList = productCategoryService.findAll();
		log.info("ページの導入完成、内容は: " + categoryList.toString() + ".");

		// WithChildrenItem临时变量=PmsProductCategory

		for (PmsProductCategory e : categoryList) {

			PmsProductCategoryWithChildrenItem tmpInstance = new PmsProductCategoryWithChildrenItem();
			BeanUtils.copyProperties(e, tmpInstance);

			if (tmpInstance.getParentId() == 0) {
				dataList.add(tmpInstance);

			}
			log.info("PmsProductCategoryWithChildrenItemのインスタンス：{}", tmpInstance);

		}

		for (PmsProductCategoryWithChildrenItem e : dataList) {
			productCategoryService.setChildrenItem(e);
			log.info("secondクラス分類：{}", dataList);
		}

		return new CommonResult(200, dataList, "ok");

	}
	
	//分页查询商品分类

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list/{parentId}")
	
	public CommonResult list(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@PathVariable Long parentId){
		
		Pageable paging = PageRequest.of(pageNum-1, pageSize);
		Page<PmsProductCategory> pmsProductCategoryList = productCategoryService.findByParentId(parentId,paging);
		
	
		
		CommonPage commonPage = CommonPage.builder().list(pmsProductCategoryList.toList()).pageNum(pageNum).pageSize(pageSize)
				.total(productCategoryService.countAll())
				.build();
		return CommonResult.builder().code(200).data(commonPage).message("OK").build();
		
	}
	

}
