package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@Entity
public class PmsProductFullReduction {
	//@Column
	private Double fullPrice;
	//@Id
	private Long id;
	//@Id
	private Integer productId;
	//@Column

	private Double reducePrice;
}
