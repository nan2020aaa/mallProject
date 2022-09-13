package com.example.demo.repositories.pms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.pms.PmsBrand;

@Repository
public interface PmsBrandRepository extends JpaRepository<PmsBrand, Long> {

}
