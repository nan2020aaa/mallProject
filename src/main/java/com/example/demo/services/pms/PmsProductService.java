package com.example.demo.services.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.request.PmsProductParam;
import com.example.demo.repositories.pms.PmsProductRepository;

@Service
public class PmsProductService {
	@Autowired
	PmsProductRepository repository;

	public boolean create(PmsProductParam param) {

		repository.save(param);
		return true;
	}

}
