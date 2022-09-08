package com.example.demo.repositories.pms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.request.PmsProductParam;

@Repository
public interface PmsProductParamRepository extends JpaRepository <PmsProductParam,PmsProductParam>{
	

}
