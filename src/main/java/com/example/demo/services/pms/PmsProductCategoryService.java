package com.example.demo.services.pms;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProduct;
import com.example.demo.models.pms.PmsProductCategory;
import com.example.demo.models.pms.PmsProductCategoryWithChildrenItem;
import com.example.demo.repositories.pms.PmsProductCategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsProductCategoryService {

	@Autowired
	private PmsProductCategoryRepository pmsProductCategoryRepository;

	public boolean create(PmsProductCategory data) {

		pmsProductCategoryRepository.save(data);

		return true;
	}

	public List<PmsProductCategory> findAll() {

		return pmsProductCategoryRepository.findAll();
	}

	// 根据ParentId判断父子类
	public void setLevel(PmsProductCategory e) {
		if (e.getParentId() != 0) {
			e.setLevel(1);
		} else {
			e.setLevel(0);
		}
	}

	public void setChildrenItem(PmsProductCategoryWithChildrenItem e) {
		if (e.getParentId() != 0) {
			e.setChildren(null);
		}else {
			e.setChildren(pmsProductCategoryRepository.findByParentId(e.getId()));
		}

	}
	public Page<PmsProductCategory> findAll(Pageable paging) {
		return pmsProductCategoryRepository.findAll(paging);
	}
	
	public Long countAll() {
		return pmsProductCategoryRepository.count();
	}

	public Page<PmsProductCategory> findByParentId(Pageable paging) {
		
		return pmsProductCategoryRepository.findByParentId();
	}
	
}
