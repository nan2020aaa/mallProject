package com.example.demo.services.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProductAttribute;
import com.example.demo.repositories.pms.PmsProductAttributeRepository;

@Service
public class PmsProductAttributeService {
	@Autowired
	PmsProductAttributeRepository repository;

	public boolean create(PmsProductAttribute pmsProductAttribute) {
		repository.save(pmsProductAttribute);
		return true;
	}

	public List<PmsProductAttribute> findAll() {
		return repository.findAll();
	}
}
