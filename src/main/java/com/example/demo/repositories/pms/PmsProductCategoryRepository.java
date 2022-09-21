package com.example.demo.repositories.pms;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsProductCategory;

@Repository
public interface PmsProductCategoryRepository extends JpaRepository<PmsProductCategory, Long> {

	List<PmsProductCategory> findByParentId(Long parentId);
	
	Page<PmsProductCategory> findByParentId(Long parentId,Pageable paging);
	
	Long countByParentId(Long parentId);

//	PmsProductCategory getParentId(Long parentId);
//
//	PmsProductCategory getLevel(Integer level);

}
