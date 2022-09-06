package com.example.demo.models.sms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.models.oms.OmsOrderDetail;
import com.example.demo.models.oms.OmsOrderItem;
import com.example.demo.models.oms.OmsOrderOperateHistory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmsCouponProductRelation {
	// 商品名称
	@Id
	private Long couponId;
	@Id
	private Long id;
	@Id
	private Long productId;
	@Column
	private String productName;

	// 商品编码
	@Column
	private String productSn;
}
