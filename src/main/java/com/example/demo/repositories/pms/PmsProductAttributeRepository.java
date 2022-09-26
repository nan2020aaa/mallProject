package com.example.demo.repositories.pms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsProductAttribute;

@Repository
public interface PmsProductAttributeRepository extends JpaRepository<PmsProductAttribute, Long> {
	List<PmsProductAttribute> findByProductAttributeCategoryId(Long productAttributeCategoryId);

	Long countByType(Integer type);
}
