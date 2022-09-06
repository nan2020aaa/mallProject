package com.example.demo.models.oms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OmsOrderSetting {
	// 订单完成后自动好评时间（天）
	@Column
	private Integer commentOvertime;

	// 发货后自动确认收货时间（天）
	@Column
	private Integer confirmOvertime;

	// 自动完成交易时间，不能申请售后（天）
	@Column
	private Integer finishOvertime;

	// 秒杀订单超时关闭时间(分)
	@Column
	private Integer flashOrderOvertime;

	// 正常订单超时时间(分)
	@Id
	private Long id;
	@Column
	private Integer normalOrderOvertime;
}
