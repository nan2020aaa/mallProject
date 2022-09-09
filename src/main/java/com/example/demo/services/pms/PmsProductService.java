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
	private PmsProductRepository repository;

	public boolean create(PmsProduct data) {

		repository.save(data);

		log.info("PmsProductService, create(), DBに保存完成：{}", data);
		return true;
	}

}
