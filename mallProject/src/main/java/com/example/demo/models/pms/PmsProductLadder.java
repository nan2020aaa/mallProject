package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PmsProductLadder {
	// 满足的商品数量
	@Column
	private Integer count;

	// 折扣
	@Column
	private Double discount;


	// 折后价格
	@Id
	private Long id;
	@Column
	private Double price;
	@Column
	private Long productId;

}
