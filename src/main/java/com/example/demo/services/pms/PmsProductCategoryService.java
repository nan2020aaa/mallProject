package com.example.demo.services.pms;

import java.util.List;

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
	private PmsProductCategoryRepository repository;

	public List<PmsProductCategory> findAll() {
		return repository.findAll();
	}
	
	public Long countAll() {
		log.info("countメソッドを呼び出した。");
		return repository.count();
	}
	
	public Long countParentId(Long parentId) {
		return repository.countByParentId(parentId);
	}
	
	public Page<PmsProductCategory> findAll(Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(paging);
	}

	public Page<PmsProductCategory> findByParentId(Long parentId,Pageable paging){
		return repository.findByParentId(parentId, paging);
	}
	
	public boolean create(PmsProductCategory data) {
		repository.save(data);

		log.info("PmsProductCategoryService, create(), DBに保存完成：{}", data);
		return true;
	}

//	public PmsProductCategory getParentId(Long parentId) {
//		return repository.getParentId(parentId);
//	}
//	
//	public PmsProductCategory getLevel(Integer level) {
//		return repository.getLevel(level);
//	}

	public void setLevel(PmsProductCategory data) {
		if (data.getParentId() != 0) {
			data.setLevel(1);
		} else {
			data.setLevel(0);
		}
	}

	public void setChildrenItem(PmsProductCategoryWithChildrenItem e) {
		log.info("serviceのsecondクラス：{}", e);
		if (e.getParentId() != 0) {
			e.setChildren(null);
		} else {
			e.setChildren(repository.findByParentId(e.getId()));
		}
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
