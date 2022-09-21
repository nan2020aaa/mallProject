package com.example.demo.services.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProductCategory;
import com.example.demo.models.pms.PmsProductCategoryWithChildrenItem;
import com.example.demo.repositories.pms.PmsProductCategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsProductCategoryService {
	@Autowired
	private PmsProductCategoryRepository repository;

	public boolean create(PmsProductCategory data) {

		repository.save(data);

		log.info("PmsProductCategoryService, create(), DBに保存完成：{}", data);
		return true;
	}

	// 根据parentId设置子分类的分类级别
	public void setLevel(PmsProductCategory e) {
		if (e.getParentId() != 0) {
			e.setLevel(1);
		} else {
			e.setLevel(0);
		}
	}

	public List<PmsProductCategory> findByParentId(Long id) {
		return repository.findByParentId(id);
	}
}
