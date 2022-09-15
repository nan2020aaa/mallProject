package com.example.demo.repositories.pms;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.pms.PmsProductCategory;

public interface PmsProductCategoryRepository extends JpaRepository<PmsProductCategory, Long>  {

}
