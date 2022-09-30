package com.example.demo.services.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProductAttributeCategory;
import com.example.demo.repositories.pms.PmsProductAttributeCategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsProductAttributeCategoryService {
	@Autowired
	PmsProductAttributeCategoryRepository repository;

	public boolean create(PmsProductAttributeCategory pmsProductAttributeCategory) {
		repository.save(pmsProductAttributeCategory);
		return true;
	}

	public Page<PmsProductAttributeCategory> findAll(Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(paging);
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

	public List<PmsProductAttributeCategory> findAll() {
		return repository.findAll();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public void updateById(PmsProductAttributeCategory data) {
		repository.save(data);
	}
}
