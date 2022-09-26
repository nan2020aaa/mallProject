package com.example.demo.repositories.pms;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsProduct;

@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct, Long> {
	PmsProduct findByBrandId(Long brandId);

	PmsProduct findByKeywords(String keyword);

	PmsProduct findByProductCategoryId(Long productCategoryId);

	PmsProduct findByProductSn(String productSn);

	PmsProduct findByPublishStatus(Integer publishStatus);

	PmsProduct findByVerifyStatus(Integer verifyStatus);

	//Page<PmsProduct> findByBrandId(Pageable paging);

	

	
}
