package com.example.demo.models.oms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OmsUpdateStatusParam {
	// 收货地址关联id
	@Id
	private Long companyAddressId;

	// 处理人
	@Column
	private String handleMan;

	// 处理备注
	@Column
	private String handleNote;

	// 服务单号
	@Id
	private Long id;

	// 收货人
	@Column
	private String receiveMan;

	// 收货备注
	@Column
	private String receiveNote;

	// 确认退款金额
	@Column
	private Double returnAmount;

	// 申请状态：1->退货中；2->已完成；3->已拒绝
	@Column
	private Integer status;
}
