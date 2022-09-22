package com.example.demo.repositories.pms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsProductAttribute;

@Repository
public interface PmsProductAttributeRepository extends JpaRepository<PmsProductAttribute, Long> {

}
