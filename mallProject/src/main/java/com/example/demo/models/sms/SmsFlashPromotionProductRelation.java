package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmsFlashPromotionProductRelation {
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
	private Number flashPromotionPrice;

	// 编号
	@Id
	private Long flashPromotionSessionId;

	// 编号
	@Id
	private Long id;

	// 排序
	@Id
	private Long productId;
	@Column
	private Integer sort;
}
