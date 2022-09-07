package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@NoArgsConstructor
public class SmsCouponProductRelation {
	// 商品名称
	//@Id
	private Long couponId;
	//@Id
	private Long id;
	//@Id
	private Long productId;
	//@Column
	private String productName;

	// 商品编码
	//@Column
	private String productSn;
}
