package com.example.demo.services.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProductAttribute;
import com.example.demo.repositories.pms.PmsProductAttributeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsProductAttributeService {
	@Autowired
	PmsProductAttributeRepository repository;

	public boolean create(PmsProductAttribute pmsProductAttribute) {
		repository.save(pmsProductAttribute);
		return true;
	}

	public List<PmsProductAttribute> findAll() {
		return repository.findAll();
	}

	public List<PmsProductAttribute> findByProductAttributeCategoryId(Long productAttributeCategoryId) {
		return repository.findByProductAttributeCategoryId(productAttributeCategoryId);
	}

	public Long countByType(Integer type) {
		return repository.countByType(type);
	}

	public Integer getTotalPageDependsOnContent(Integer type, Integer pageSize) {
		if (countByType(type) % pageSize == 0) {
			log.info("getTotalPageメソッドを呼び出した、要求されたページは内容で満たされている。");
			return (int) (countByType(type) / pageSize);
		} else {
			log.info("getTotalPageメソッドを呼び出した、要求されたページは内容で満たされていない。");
			return (int) ((countByType(type) / pageSize) + 1);
		}
	}
}
