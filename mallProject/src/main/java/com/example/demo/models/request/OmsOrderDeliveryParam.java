package com.example.demo.models.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OmsOrderDeliveryParam {

	// 物流公司
	@Column
	private String deliveryCompany;

	// 物流单号
	@Column
	private String deliverySn;

	// 订单id
	@Id
	private Long orderId;
}
