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
public class SmsCouponProductCategoryRelation {
	// 父分类名称
	@Id
	private Long couponId;
	@Id
	private Long id;
	@Column
	private String parentCategoryName;

	// 产品分类名称
	@Id
	private Long productCategoryId;
	@Column
	private String productCategoryName;
}
