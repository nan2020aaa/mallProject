package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@NoArgsConstructor
public class SmsCouponHistory {
	// 获取类型：0->后台赠送；1->主动获取
	//@Column
	private String couponCode;
	//@Id
	private Long couponId;
	//@Column
	private String createTime;
	//@Column
	private Integer getType;

	// 领取人昵称
	//@Id
	private Long id;
	//@Id
	private Long memberId;
	//@Column
	private String memberNickname;

	// 订单编号
	//@Id
	private Long orderId;

	// 订单号码
	//@Column
	private String orderSn;

	// 使用状态：0->未使用；1->已使用；2->已过期
	//@Column
	private Integer useStatus;

	// 使用时间
	//@Column
	private String useTime;
}
