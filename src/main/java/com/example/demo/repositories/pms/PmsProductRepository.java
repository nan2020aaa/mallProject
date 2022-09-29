package com.example.demo.repositories.pms;

import org.springframework.data.domain.Example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsProduct;

@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct, Long> {
	Page<PmsProduct> findByBrandId(@Param(value = "brandId") Long brandId, Pageable paging);

	Page<PmsProduct> findByKeywords(@Param(value = "keyword") String keyword, Pageable paging);

	Page<PmsProduct> findByProductCategoryId(@Param(value = "productCategoryId") Long productCategoryId,
			Pageable paging);

	Page<PmsProduct> findByProductSn(@Param(value = "productSn") String productSn, Pageable paging);

	Page<PmsProduct> findByPublishStatus(@Param(value = "publishStatus") Integer publishStatus, Pageable paging);

	Page<PmsProduct> findByVerifyStatus(@Param(value = "verifyStatus") Integer verifyStatus, Pageable paging);

//	PmsProduct findByKeywords(String keyword);
//
//	PmsProduct findByProductCategoryId(Long productCategoryId);
//
//	PmsProduct findByProductSn(String productSn);
//
//	PmsProduct findByPublishStatus(Integer publishStatus);
//
//	PmsProduct findByVerifyStatus(Integer verifyStatus);

}
