package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.models.pms.PmsProductCategory;
import com.example.demo.models.request.PmsProductCategoryParam;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PmsProductCategoryControllerTest {
	@MockBean
	PmsProductCategoryService pmsProductCategoryService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreate_Succeed_ReturnCode200() throws UnsupportedEncodingException, Exception {
		// 执行调用pmsProductCategoryService.create()方法后（符合规范的任意参数），返回true
		when(pmsProductCategoryService.create(any())).thenReturn(true);

		// 构造ProductCategory参数表
		PmsProductCategoryParam param = PmsProductCategoryParam.builder().build();

		// 将参数表转换为json格式
		ObjectMapper mapper = new ObjectMapper();
		String paramJson = mapper.writeValueAsString(param);

		// 得到json格式的结果
		String resultJson = mockMvc
				.perform(post("/productCategory/create").contentType(MediaType.APPLICATION_JSON).content(paramJson))
				.andReturn().getResponse().getContentAsString();

		// 构造期待的结果并转换成json格式
		CommonResult expectResult = CommonResult.builder().code(200).data(null).message("OK").build();
		String expectResultJson = mapper.writeValueAsString(expectResult);

		// 断言两个结果相等
		assertEquals(expectResultJson, resultJson);
	}

	@Test
	public void testCreate_Failed_ReturnCode500() throws UnsupportedEncodingException, Exception {
		// 执行调用pmsProductCategoryService.create()方法后（符合规范的任意参数），返回true
		when(pmsProductCategoryService.create(any())).thenReturn(false);

		// 构造ProductCategory参数表
		PmsProductCategoryParam param = PmsProductCategoryParam.builder().build();

		// 将参数表转换为json格式
		ObjectMapper mapper = new ObjectMapper();
		String paramJson = mapper.writeValueAsString(param);

		// 得到json格式的结果
		String resultJson = mockMvc
				.perform(post("/productCategory/create").contentType(MediaType.APPLICATION_JSON).content(paramJson))
				.andReturn().getResponse().getContentAsString();

		// 构造期待的结果并转换成json格式
		CommonResult expectResult = CommonResult.builder().code(500).data(null).message("System error").build();
		String expectResultJson = mapper.writeValueAsString(expectResult);

		// 断言两个结果相等
		assertEquals(expectResultJson, resultJson);
	}

	@Test
	public void testListWithChildren_Succeed() throws Exception {
		// 模拟结果的body部分显示的PmsProductCategory列表
		PmsProductCategory pmsProductCategory1 = PmsProductCategory.builder().id(1l).parentId(0l).build();
		List<PmsProductCategory> dataList = new ArrayList<>();
		dataList.add(pmsProductCategory1);

		PmsProductCategory pmsProductCategory2 = PmsProductCategory.builder().id(2l).parentId(1l).build();
		List<PmsProductCategory> setList = new ArrayList<>();
		setList.add(pmsProductCategory2);

		// 设置Service层桩对象的返回结果
//		when(pmsProductCategoryService.findByParentId(0l)).thenReturn(dataList);
//		when(pmsProductCategoryService.findByParentId(1l)).thenReturn(setList);

		// 使用MockMvc对象的perform方法访问服务器输入参数；使用jsonPath方法断言结果的值
		mockMvc.perform(get("/productCategory/list/withChildren")).andExpect(jsonPath("$.code").value(200))
				.andExpect(jsonPath("$.message").value("OK")).andExpect(jsonPath("$.data[0].parentId").value(0l))
				.andExpect(jsonPath("$.data[0].id").value(1l)).andExpect(jsonPath("$.data[0].children").isNotEmpty());
	}
}