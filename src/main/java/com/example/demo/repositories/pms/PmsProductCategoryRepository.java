package com.example.demo.repositories.pms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsProductCategory;

@Repository
public interface PmsProductCategoryRepository extends JpaRepository<PmsProductCategory, Long> {

	List<PmsProductCategory> findByParentId(Long id);

//	PmsProductCategory getParentId(Long parentId);
//
//	PmsProductCategory getLevel(Integer level);

}
