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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.models.pms.PmsProduct;
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
		PmsProductParam param = PmsProductParam.builder().build();

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
		PmsProductParam param = PmsProductParam.builder().build();

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

	@Test
	public void testList_HasRemainderRecord_Succeed() throws UnsupportedEncodingException, Exception {
		// 模拟结果的body部分显示的PmsProduct列表
		PmsProduct pmsProduct = PmsProduct.builder().build();
		List<PmsProduct> list = new ArrayList<>();
		list.add(pmsProduct);

		// 将得到的列表包装成Page类
		Pageable paging = PageRequest.of(0, 2);
		Page<PmsProduct> page = new PageImpl<>(list, paging, 1l);

		// 设置Service层桩对象的返回结果
//		when(pmsProductService.findAll(paging)).thenReturn(page);
		when(pmsProductService.countAll()).thenReturn(1l);
		when(pmsProductService.getTotalPageDependsOnContent(2)).thenReturn(1);

		// 使用MockMvc对象的perform方法访问服务器输入参数；使用jsonPath方法断言结果的值
		mockMvc.perform(get("/product/list").param("pageNum", "1").param("pageSize", "2"))
				.andExpect(jsonPath("$.code").value(200)).andExpect(jsonPath("$.message").value("OK"))
				.andExpect(jsonPath("$.data.list[0]").value(list.get(0))).andExpect(jsonPath("$.data.pageNum").value(1))
				.andExpect(jsonPath("$.data.pageSize").value(2)).andExpect(jsonPath("$.data.total").value(1l))
				.andExpect(jsonPath("$.data.totalPage").value(1));
	}

	@Test
	public void testList_NoRemainderRecord_Succeed() throws UnsupportedEncodingException, Exception {
		PmsProduct pmsProduct1 = PmsProduct.builder().build();
		PmsProduct pmsProduct2 = PmsProduct.builder().build();
		List<PmsProduct> list = new ArrayList<>();
		list.add(pmsProduct1);
		list.add(pmsProduct2);

		Pageable paging = PageRequest.of(0, 2);
		Page<PmsProduct> page = new PageImpl<>(list, paging, 1l);

//		when(pmsProductService.findAll(paging)).thenReturn(page);
		when(pmsProductService.countAll()).thenReturn(2l);
		when(pmsProductService.getTotalPageDependsOnContent(2)).thenReturn(1);

		mockMvc.perform(get("/product/list").param("pageNum", "1").param("pageSize", "2"))
				.andExpect(jsonPath("$.code").value(200)).andExpect(jsonPath("$.message").value("OK"))
				.andExpect(jsonPath("$.data.list[0]").value(list.get(0)))
				.andExpect(jsonPath("$.data.list[1]").value(list.get(1))).andExpect(jsonPath("$.data.pageNum").value(1))
				.andExpect(jsonPath("$.data.pageSize").value(2)).andExpect(jsonPath("$.data.total").value(2l))
				.andExpect(jsonPath("$.data.totalPage").value(1));
	}
}
