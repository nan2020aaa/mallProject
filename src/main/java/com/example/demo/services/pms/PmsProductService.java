package com.example.demo.services.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProduct;
import com.example.demo.repositories.pms.PmsProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsProductService {
	@Autowired
	PmsProductRepository repository;

	public boolean create(PmsProduct data) {
		repository.save(data);
		log.info("数据录入成功");
		return true;
	}
	
	public PmsProduct getByBrandId(Long id) {
		return repository.getByBrandId(id);
	}
	
	public PmsProduct getByKeywords(String keyword) {
		return repository.getByKeywords(keyword);
	}
	
	public PmsProduct getByProductCategoryId(Long productCategoryId) {
		return repository.getByProductCategoryId(productCategoryId);
	}
	
	public PmsProduct getByProductSn(String productSn) {
		return repository.getByProductSn(productSn);
	}
	
	public PmsProduct getByPublishStatus(Integer publishStatus) {
		return repository.getByPublishStatus(publishStatus);
	}
	
	public PmsProduct getByVerifyStatus(Integer verifyStatus) {
		return repository.getByVerifyStatus(verifyStatus);
	}

}
