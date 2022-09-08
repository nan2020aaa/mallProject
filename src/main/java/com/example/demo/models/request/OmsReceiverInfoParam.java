package com.example.demo.models.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@NoArgsConstructor
public class OmsReceiverInfoParam {
	// 订单ID
	//@Id
	private Long orderId;

	// 城市
	//@Column
	private String receiverCity;

	// 详细地址
	//@Column
	private String receiverDetailAddress;

	// 收货人姓名
	//@Column
	private String receiverName;

	// 收货人电话
	//@Column
	private String receiverPhone;

	// 收货人邮编
	//@Column
	private String receiverPostCode;

	// 省份/直辖市
	//@Column
	private String receiverProvince;

	// 区
	//@Column
	private String receiverRegion;

	// 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
	//@Column
	private Integer status;
}
