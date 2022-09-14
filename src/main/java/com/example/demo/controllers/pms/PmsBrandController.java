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

import com.example.demo.models.pms.PmsBrand;
import com.example.demo.models.pms.PmsProduct;
import com.example.demo.models.request.PmsBrandParam;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsBrandService;

import lombok.Builder;
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
			return CommonResult.builder().code(500).data(null).message("OK").build();
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/listAll")
	public CommonResult listAll() {
		log.info("listAllメソッド導入成功。");
		List<PmsBrand> targetList = new ArrayList<>();
		brandService.findAll().forEach((e) -> {
			targetList.add(e);
		});
		log.info("targetList添加成功、" + targetList.toString());
		return CommonResult.builder().code(200).data(targetList).message("OK").build();
	}
}
