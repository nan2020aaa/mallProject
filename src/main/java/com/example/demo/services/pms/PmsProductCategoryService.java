package com.example.demo.services.pms;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProductCategory;
import com.example.demo.models.pms.PmsProductCategoryWithChildrenItem;
import com.example.demo.repositories.pms.PmsProductCategoryRepository;

@Service
public class PmsProductCategoryService {
	
	 @Autowired
		private PmsProductCategoryRepository pmsProductCategoryRepository;
	
	public boolean create(PmsProductCategory data) {
	
		return true;
	}
	
	public List<PmsProductCategory> findAll() {
		
		return pmsProductCategoryRepository.findAll();
		
		
	}

	

}
