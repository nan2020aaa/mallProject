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

}
