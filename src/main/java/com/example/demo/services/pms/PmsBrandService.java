package com.example.demo.services.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
