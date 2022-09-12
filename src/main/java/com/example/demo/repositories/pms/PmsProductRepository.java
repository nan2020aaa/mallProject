package com.example.demo.repositories.pms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsProduct;

@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct, Long> {
	PmsProduct getByBrandId(Long brandId);

	PmsProduct getByKeywords(String keyword);

	PmsProduct getByProductCategoryId(Long productCategoryId);

	PmsProduct getByProductSn(String productSn);

	PmsProduct getByPublishStatus(Integer publishStatus);

	PmsProduct getByVerifyStatus(Integer verifyStatus);
}