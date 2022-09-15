package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.models.request.PmsProductParam;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PmsProductControllerTest {
	@MockBean
	PmsProductService pmsProductService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreate_Succeed_ReturnCode200() throws UnsupportedEncodingException, Exception {
		// 执行调用pmsProductService.create()方法后（符合规范的任意参数），返回true
		when(pmsProductService.create(any())).thenReturn(true);

		// 构造Product参数表
		PmsProductParam param = PmsProductParam.builder()
				/*
				 * .albumPics("string").brandId(0l).brandName("string")
				 * .deleteStatus(0).description("string").detailDesc("string").detailHtml(
				 * "string")
				 * .detailMobileHtml("string").detailTitle("string").feightTemplateId(0l).
				 * giftGrowth(0).giftPoint(0)
				 * .keywords("string").lowStock(0).name("string").newStatus(0).note("string").
				 * originalPrice(0.0)
				 * .previewStatus(0).price(0.0).productAttributeCategoryId(0l).productCategoryId
				 * (0l) .productCategoryName("string").productSn("string").promotionEndTime(
				 * "2022-09-09T02:27:01.346Z")
				 * .promotionPerLimit(0).promotionPrice(0.0).promotionStartTime(
				 * "2022-09-09T02:27:01.346Z")
				 * .promotionType(0).publishStatus(0).recommandStatus(0).sale(0).serviceIds(
				 * "string").sort(0).stock(0)
				 * .subTitle("string").unit("string").usePointLimit(0).verifyStatus(0).weight(0.
				 * 0)
				 */.build();

		// 将参数表转换为json格式
		ObjectMapper mapper = new ObjectMapper();
		String paramJson = mapper.writeValueAsString(param);

		// 得到json格式的结果
		String resultJson = mockMvc
				.perform(post("/product/create").contentType(MediaType.APPLICATION_JSON).content(paramJson)).andReturn()
				.getResponse().getContentAsString();

		// 构造期待的结果并转换成json格式
		CommonResult expectResult = CommonResult.builder().code(200).data(null).message("OK").build();
		String expectResultJson = mapper.writeValueAsString(expectResult);

		// 断言两个结果相等
		assertEquals(expectResultJson, resultJson);
	}

	@Test
	public void testCreate_Failed_ReturnCode500() throws UnsupportedEncodingException, Exception {
		// 执行调用pmsProductService.create()方法后（符合规范的任意参数），返回true
		when(pmsProductService.create(any())).thenReturn(false);

		// 构造Product参数表
		PmsProductParam param = PmsProductParam.builder()
				/*
				 * .albumPics("string").brandId(0l).brandName("string")
				 * .deleteStatus(0).description("string").detailDesc("string").detailHtml(
				 * "string")
				 * .detailMobileHtml("string").detailTitle("string").feightTemplateId(0l).
				 * giftGrowth(0).giftPoint(0)
				 * .keywords("string").lowStock(0).name("string").newStatus(0).note("string").
				 * originalPrice(0.0)
				 * .previewStatus(0).price(0.0).productAttributeCategoryId(0l).productCategoryId
				 * (0l) .productCategoryName("string").productSn("string").promotionEndTime(
				 * "2022-09-09T02:27:01.346Z")
				 * .promotionPerLimit(0).promotionPrice(0.0).promotionStartTime(
				 * "2022-09-09T02:27:01.346Z")
				 * .promotionType(0).publishStatus(0).recommandStatus(0).sale(0).serviceIds(
				 * "string").sort(0).stock(0)
				 * .subTitle("string").unit("string").usePointLimit(0).verifyStatus(0).weight(0.
				 * 0)
				 */.build();

		// 将参数表转换为json格式
		ObjectMapper mapper = new ObjectMapper();
		String paramJson = mapper.writeValueAsString(param);

		// 得到json格式的结果
		String resultJson = mockMvc
				.perform(post("/product/create").contentType(MediaType.APPLICATION_JSON).content(paramJson)).andReturn()
				.getResponse().getContentAsString();

		// 构造期待的结果并转换成json格式
		CommonResult expectResult = CommonResult.builder().code(500).data(null).message("System error").build();
		String expectResultJson = mapper.writeValueAsString(expectResult);

		// 断言两个结果相等
		assertEquals(expectResultJson, resultJson);
	}

//	@Test
//	public void testList_Succeed() throws JsonProcessingException {
//	}
}
