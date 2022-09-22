package com.example.demo.services.pms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsBrand;
import com.example.demo.repositories.pms.PmsBrandRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsBrandService {
	@Autowired
	private PmsBrandRepository repository;

	public List<PmsBrand> findAll() {
		log.info("brand全部検索: " + repository.findAll().toString() + ".");
		return repository.findAll();
	}

	public boolean create(PmsBrand param) {
		repository.save(param);
		log.info("PmsBrandService, create(), DBに保存完成：{}", param);
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

	public Page<PmsBrand> findAll(Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(paging);
	}

	public Page<PmsBrand> findByName(String name, Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findByName(name, paging);
	}
}
