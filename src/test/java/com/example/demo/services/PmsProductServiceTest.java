package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

import com.example.demo.models.pms.PmsProduct;
import com.example.demo.repositories.pms.PmsProductRepository;
import com.example.demo.services.pms.PmsProductService;

@SpringBootTest
public class PmsProductServiceTest {
	private static PmsProductService demo;

	@MockBean
	private PmsProductRepository pmsProductRepository;

	@Autowired
	private PmsProductService pmsProductService;

	@Test
	public void testCountAll_Succeed() {
		assertEquals(pmsProductService.countAll(), pmsProductRepository.count());
	}

	@Test
	public void testGetTotalPageDependsOnContent_NoRemainder_Succeed() {
		when(pmsProductRepository.count()).thenReturn(10l);
		Integer pageSize = 5;
		assertEquals((int) (pmsProductService.getTotalPageDependsOnContent(pageSize)),
				(int) (pmsProductService.countAll() / pageSize));
	}

	@Test
	public void testGetTotalPageDependsOnContent_HasRemainder_Succeed() {
		when(pmsProductRepository.count()).thenReturn(11l);
		Integer pageSize = 5;
		assertEquals((int) (pmsProductService.getTotalPageDependsOnContent(pageSize)),
				(int) (pmsProductService.countAll() / pageSize) + 1);
	}
}
