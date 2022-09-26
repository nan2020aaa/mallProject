package com.example.demo.services.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

	public Page<PmsProduct> findAll(Example<PmsProduct> example, Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(example,paging);
	}


//	public Page<PmsProduct> findByBrandId(Pageable paging) {
//		
//		return repository.findByBrandId(paging);
//	}
}
