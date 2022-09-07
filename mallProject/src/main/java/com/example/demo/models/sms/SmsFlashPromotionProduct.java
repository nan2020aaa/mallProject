package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.models.pms.PmsProduct;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmsFlashPromotionProduct {
	// 限时购数量
	@Column
	private Integer flashPromotionCount;

	// 每人限购数量
	@Id
	private Long flashPromotionId;
	@Column
	private Integer flashPromotionLimit;

	// 限时购价格
	@Column
	private Double flashPromotionPrice;

	// 编号
	@Id
	private Long flashPromotionSessionId;

	// 编号
	@Id
	private Long id;

	// 排序
	@Column
	private PmsProduct product;
	@Id
	private Long productId;
	@Column
	private Integer sort;
}
