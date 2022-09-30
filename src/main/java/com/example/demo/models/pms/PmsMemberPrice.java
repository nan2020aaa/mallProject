package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PmsMemberPrice {
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "productParam_id")
//	private PmsProductParam productParam;
	
	// 会员价格
	@Id
	private Long id;
	
	@Column
	private Long memberLevelId;
	
	@Column
	private String memberLevelName;
	
	@Column
	private Double memberPrice;

	@Column
	private Long productId;
}
