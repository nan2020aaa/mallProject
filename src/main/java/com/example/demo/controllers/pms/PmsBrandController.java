package com.example.demo.controllers.pms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

import com.example.demo.models.pms.PmsBrand;
import com.example.demo.models.pms.PmsProduct;
import com.example.demo.models.request.PmsBrandParam;
import com.example.demo.models.response.CommonPage;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsBrandService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/brand") // 所有本类中方法的请求路径都以 /brand 开头
@Controller
@Slf4j
public class PmsBrandController {
	@Autowired
	private PmsBrandService brandService;

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create")
	public CommonResult create(@RequestBody PmsBrandParam param) { // 传入参数为 RequestBody （在文档中标识为 body）

		log.info("PmsBrandController, /create, パラメータを受け取った：{}", param);
		PmsBrand data = PmsBrand.builder().build();
		BeanUtils.copyProperties(param, data);
		log.info("BeanCopy完成：{}", data);
		if (brandService.create(data)) {
			log.info("DBに保存完成：{}", data);
			return CommonResult.builder().code(200).data(null).message("OK").build();
		} else {
			return CommonResult.builder().code(500).data(null).message("System error").build();
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/listAll")
	public CommonResult listAll() {
		log.info("listAllメソッド導入成功。");
		List<PmsBrand> targetList = new ArrayList<>();
		targetList = brandService.findAll();
		log.info("targetList添加成功、" + targetList.toString());
		return CommonResult.builder().code(200).data(targetList).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list")
	public CommonResult list(@RequestParam(required = false) String keyword, @RequestParam Integer pageNum,
			@RequestParam Integer pageSize) {
		Pageable paging = PageRequest.of(pageNum - 1, pageSize);
		log.info("pagingというインスタンス作成、pageNum: " + pageNum + "; pageSize: " + pageSize + ".");

		PmsBrand brand = new PmsBrand();
		brand.setName(keyword);

		// 用example matching的方法查询，大小写自由，包含关系
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", match -> match.ignoreCase().contains());

		Example<PmsBrand> example = Example.of(brand, matcher);
		// 查找并返回页数
		Page<PmsBrand> brands = brandService.findAll(example, paging);
		brands.forEach(System.out::println);
		log.info("ページの導入完成、内容は: " + brands.toList().toString() + ".");

		Long count = 0L;
		for (PmsBrand e : brands) {
			count++;
		}

		CommonPage commonPage = CommonPage.builder().list(brands.toList()).pageNum(pageNum).pageSize(pageSize)
				.total(brandService.countAll()).totalPage(brandService.getTotalPageDependsOnContent(pageSize)).build();
		return CommonResult.builder().code(200).data(commonPage).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/delete/{id}")
	public CommonResult deleteById(@PathVariable Long id) {
		brandService.deleteById(id);
		return CommonResult.builder().code(200).data(null).message("OK").build();
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/update/{id}")
	public CommonResult updateById(@PathVariable Long id, @RequestBody PmsBrandParam pmsBrandParam) {
		PmsBrand data = PmsBrand.builder().build();
		BeanUtils.copyProperties(pmsBrandParam, data);
		data.setId(id);
		brandService.updateById(data);
		return CommonResult.builder().code(200).data(null).message("OK").build();
	}
}
