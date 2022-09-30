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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.models.pms.PmsBrand;
import com.example.demo.models.request.PmsBrandParam;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsBrandService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PmsBrandControllerTest {
	@MockBean
	PmsBrandService pmsBrandService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreate_Succeed_ReturnCode200() throws UnsupportedEncodingException, Exception {
		// 执行调用pmsBrandService.create()方法后（符合规范的任意参数），返回true
		when(pmsBrandService.create(any())).thenReturn(true);

		// 构造Brand参数表
		PmsBrandParam param = PmsBrandParam.builder().build();

		// 将参数表转换为json格式
		ObjectMapper mapper = new ObjectMapper();
		String paramJson = mapper.writeValueAsString(param);

		// 得到json格式的结果
		String resultJson = mockMvc
				.perform(post("/brand/create").contentType(MediaType.APPLICATION_JSON).content(paramJson)).andReturn()
				.getResponse().getContentAsString();

		// 构造期待的结果并转换成json格式
		CommonResult expectResult = CommonResult.builder().code(200).data(null).message("OK").build();
		String expectResultJson = mapper.writeValueAsString(expectResult);

		// 断言两个结果相等
		assertEquals(expectResultJson, resultJson);
	}

	@Test
	public void testCreate_Failed_ReturnCode500() throws UnsupportedEncodingException, Exception {
		// 执行调用pmsBrandService.create()方法后（符合规范的任意参数），返回true
		when(pmsBrandService.create(any())).thenReturn(false);

		// 构造Brand参数表
		PmsBrandParam param = PmsBrandParam.builder().build();

		// 将参数表转换为json格式
		ObjectMapper mapper = new ObjectMapper();
		String paramJson = mapper.writeValueAsString(param);

		// 得到json格式的结果
		String resultJson = mockMvc
				.perform(post("/brand/create").contentType(MediaType.APPLICATION_JSON).content(paramJson)).andReturn()
				.getResponse().getContentAsString();

		// 构造期待的结果并转换成json格式
		CommonResult expectResult = CommonResult.builder().code(500).data(null).message("System error").build();
		String expectResultJson = mapper.writeValueAsString(expectResult);

		// 断言两个结果相等
		assertEquals(expectResultJson, resultJson);
	}

	@Test
	public void testList_HasRemainderRecordAndKeywordIsNull_Succeed() throws UnsupportedEncodingException, Exception {
		// 模拟结果的body部分显示的PmsBrand列表
		PmsBrand pmsBrand = PmsBrand.builder().build();
		List<PmsBrand> list = new ArrayList<>();
		list.add(pmsBrand);

		// 将得到的列表包装成Page类
		Example<PmsBrand> example = Example.of(pmsBrand);
		Pageable paging = PageRequest.of(0, 2);
		Page<PmsBrand> page = new PageImpl<>(list, paging, 1l);

		// 设置Service层桩对象的返回结果
		when(pmsBrandService.findAll(example,paging)).thenReturn(page);
		when(pmsBrandService.countAll()).thenReturn(1l);
		when(pmsBrandService.getTotalPageDependsOnContent(2)).thenReturn(1);

		// 使用MockMvc对象的perform方法访问服务器输入参数；使用jsonPath方法断言结果的值
		mockMvc.perform(get("/brand/list").param("pageNum", "1").param("pageSize", "2"))
				.andExpect(jsonPath("$.code").value(200)).andExpect(jsonPath("$.message").value("OK"))
				.andExpect(jsonPath("$.data.list[0]").value(list.get(0))).andExpect(jsonPath("$.data.pageNum").value(1))
				.andExpect(jsonPath("$.data.pageSize").value(2)).andExpect(jsonPath("$.data.total").value(1l))
				.andExpect(jsonPath("$.data.totalPage").value(1));
	}

	@Test
	public void testList_NoRemainderRecordAndKeywordIsNull_Succeed() throws UnsupportedEncodingException, Exception {
		PmsBrand pmsBrand1 = PmsBrand.builder().build();
		PmsBrand pmsBrand2 = PmsBrand.builder().build();
		List<PmsBrand> list = new ArrayList<>();
		list.add(pmsBrand1);
		list.add(pmsBrand2);

		Pageable paging = PageRequest.of(0, 2);
		Page<PmsBrand> page = new PageImpl<>(list, paging, 1l);

		when(pmsBrandService.findAll(paging)).thenReturn(page);
		when(pmsBrandService.countAll()).thenReturn(2l);
		when(pmsBrandService.getTotalPageDependsOnContent(2)).thenReturn(1);

		mockMvc.perform(get("/brand/list").param("pageNum", "1").param("pageSize", "2"))
				.andExpect(jsonPath("$.code").value(200)).andExpect(jsonPath("$.message").value("OK"))
				.andExpect(jsonPath("$.data.list[0]").value(list.get(0)))
				.andExpect(jsonPath("$.data.list[1]").value(list.get(1))).andExpect(jsonPath("$.data.pageNum").value(1))
				.andExpect(jsonPath("$.data.pageSize").value(2)).andExpect(jsonPath("$.data.total").value(2l))
				.andExpect(jsonPath("$.data.totalPage").value(1));
	}

	@Test
	public void testList_HasRemainderRecordAndKeywordHasEmptyContent_Succeed()
			throws UnsupportedEncodingException, Exception {
		// 模拟结果的body部分显示的PmsBrand列表
		PmsBrand pmsBrand = PmsBrand.builder().build();
		List<PmsBrand> list = new ArrayList<>();
		list.add(pmsBrand);

		// 将得到的列表包装成Page类
		Pageable paging = PageRequest.of(0, 2);
		Page<PmsBrand> page = new PageImpl<>(list, paging, 1l);

		// 设置Service层桩对象的返回结果
		when(pmsBrandService.findAll(paging)).thenReturn(page);
		when(pmsBrandService.countAll()).thenReturn(1l);
		when(pmsBrandService.getTotalPageDependsOnContent(2)).thenReturn(1);

		// 使用MockMvc对象的perform方法访问服务器输入参数；使用jsonPath方法断言结果的值
		mockMvc.perform(get("/brand/list").param("keyword", "").param("pageNum", "1").param("pageSize", "2"))
				.andExpect(jsonPath("$.code").value(200)).andExpect(jsonPath("$.message").value("OK"))
				.andExpect(jsonPath("$.data.list[0]").value(list.get(0))).andExpect(jsonPath("$.data.pageNum").value(1))
				.andExpect(jsonPath("$.data.pageSize").value(2)).andExpect(jsonPath("$.data.total").value(1l))
				.andExpect(jsonPath("$.data.totalPage").value(1));
	}

	@Test
	public void testList_NoRemainderRecordAndKeywordHasEmptyContent_Succeed()
			throws UnsupportedEncodingException, Exception {
		PmsBrand pmsBrand1 = PmsBrand.builder().build();
		PmsBrand pmsBrand2 = PmsBrand.builder().build();
		List<PmsBrand> list = new ArrayList<>();
		list.add(pmsBrand1);
		list.add(pmsBrand2);

		Pageable paging = PageRequest.of(0, 2);
		Page<PmsBrand> page = new PageImpl<>(list, paging, 1l);

		when(pmsBrandService.findAll(paging)).thenReturn(page);
		when(pmsBrandService.countAll()).thenReturn(2l);
		when(pmsBrandService.getTotalPageDependsOnContent(2)).thenReturn(1);

		mockMvc.perform(get("/brand/list").param("keyword", "").param("pageNum", "1").param("pageSize", "2"))
				.andExpect(jsonPath("$.code").value(200)).andExpect(jsonPath("$.message").value("OK"))
				.andExpect(jsonPath("$.data.list[0]").value(list.get(0)))
				.andExpect(jsonPath("$.data.list[1]").value(list.get(1))).andExpect(jsonPath("$.data.pageNum").value(1))
				.andExpect(jsonPath("$.data.pageSize").value(2)).andExpect(jsonPath("$.data.total").value(2l))
				.andExpect(jsonPath("$.data.totalPage").value(1));
	}

	@Test
	public void testListAll_Succeed() throws Exception {
		PmsBrand pmsBrand = PmsBrand.builder().name("name").build();
		List<PmsBrand> list = new ArrayList<>();
		list.add(pmsBrand);

		when(pmsBrandService.findAll()).thenReturn(list);

		mockMvc.perform(get("/brand/listAll")).andExpect(jsonPath("$.code").value(200))
				.andExpect(jsonPath("$.message").value("OK")).andExpect(jsonPath("$.data[0].name").value("name"));
	}
}
