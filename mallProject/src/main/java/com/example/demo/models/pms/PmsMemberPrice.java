package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PmsMemberPrice {
	// 会员价格
	@Id
	private Long id;
	@Id
	private Long memberLevelId;
	@Column
	private String memberLevelName;
	@Column
	private Number memberPrice;

	@Id
	private Long productId;

}
