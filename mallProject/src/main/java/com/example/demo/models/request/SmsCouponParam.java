package com.example.demo.models.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.models.sms.SmsCouponProductCategoryRelation;
import com.example.demo.models.sms.SmsCouponProductRelation;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@NoArgsConstructor
public class SmsCouponParam {
	// 金额
	//@Column
	private Double amount;

	// 优惠码
	//@Column
	private String code;

	// 数量
	//@Column
	private Integer count;

	// 可以领取的日期
	//@Column
	private String enableTime;

	// 可领取的会员类型：0->无限时
	//@Column
	private String endTime;
	//@Id
	private Long id;
	//@Column
	private Integer memberLevel;

	// 使用门槛；0表示无门槛
	//@Column
	private Double minPoint;

	// 备注
	//@Column
	private String name;
	//@Column
	private String note;

	// 每人限领张数
	//@Column
	private Integer perLimit;

	// 使用平台：0->全部；1->移动；2->PC
	//@Column
	private Integer platform;

	// 优惠券绑定的商品分类
	//@Column
	private SmsCouponProductCategoryRelation productCategoryRelationList;

	// 优惠券绑定的商品
	//@Column
	private SmsCouponProductRelation productRelationList;

	// 发行数量
	//@Column
	private Integer publishCount;

	// 领取数量
	//@Column
	private Integer receiveCount;

	// 优惠券类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
	//@Column
	private String startTime;
	//@Column
	private Integer type;

	// 已使用数量
	//@Column
	private Integer useCount;

	// 使用类型：0->全场通用；1->指定分类；2->指定商品
	//@Column
	private Integer useType;
}
