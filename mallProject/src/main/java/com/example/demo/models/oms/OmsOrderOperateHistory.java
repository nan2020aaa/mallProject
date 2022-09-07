package com.example.demo.models.oms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OmsOrderOperateHistory {
	// 操作时间
	@Column
	private String createTime;

	// 备注
	@Id
	private Long id;
	@Column
	private String note;

	// 操作人：用户；系统；后台管理员
	@Column
	private String operateMan;

	// 订单id
	@Id
	private Long orderId;

	// 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
	@Column
	private Integer orderStatus;
}
