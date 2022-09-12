package com.example.demo.services.pms;

//import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProduct;
import com.example.demo.repositories.pms.PmsProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsProductService {

	@Autowired
	private PmsProductRepository repository;

	public boolean create(PmsProduct data) {

		repository.save(data);

		log.info("PmsProductService, create(), DBに保存完成：{}", data);
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

	public Long countAll() {
		log.info("countメソッドを呼び出した。");
		return repository.count();
	}

	public Integer getTotalPageDependsOnContent(Integer pageSize) {
		if (countAll() % pageSize == 0) {
			log.info("getTotalPageメソッドを呼び出した、要求されたページは内容で満たされている。");
			return (int) (countAll() / pageSize);
		} else {
			log.info("getTotalPageメソッドを呼び出した、要求されたページは内容で満たされていない。");
			return (int) ((countAll() / pageSize) + 1);
		}
	}

	public Page<PmsProduct> findAll(Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(paging);
	}

}
