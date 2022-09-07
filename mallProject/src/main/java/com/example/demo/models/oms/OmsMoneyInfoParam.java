package com.example.demo.models.oms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OmsMoneyInfoParam {

	// 管理员后台调整订单所使用的折扣金额
	@Column
	private Double discountAmount;

	// 运费金额
	@Column
	private Double freightAmount;

	// 订单ID
	@Id
	private Long orderId;

	// 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
	@Column
	private Integer status;

}
