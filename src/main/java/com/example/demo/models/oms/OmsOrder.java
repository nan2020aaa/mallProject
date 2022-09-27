package com.example.demo.models.oms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.models.pms.PmsBrand;
import com.example.demo.models.pms.PmsProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OmsOrder {

	// 自动确认时间（天）
	@Column
	private Integer autoConfirmDay;

	// 发票内容
	@Column
	private String billContent;

	// 发票抬头
	@Column
	private String billHeader;

	// 收票人邮箱
	@Column
	private String billReceiverEmail;

	// 收票人电话
	@Column
	private String billReceiverPhone;

	// 发票类型：0->不开发票；1->电子发票；2->纸质发票
	@Column
	private Integer billType;

	// 评价时间
	@Column
	private String commentTime;

	// 确认收货状态：0->未确认；1->已确认
	@Column
	private Integer confirmStatus;

	// 优惠券抵扣金额
	@Column
	private Double couponAmount;

	// 提交时间
	@Column
	private Long couponId;
	@Column
	private String createTime;

	// 删除状态：0->未删除；1->已删除
	@Column
	private Integer deleteStatus;

	// 物流公司(配送方式)
	@Column
	private String deliveryCompany;

	// 物流单号
	@Column
	private String deliverySn;

	// 发货时间
	@Column
	private String deliveryTime;

	// 管理员后台调整订单使用的折扣金额
	@Column
	private Double discountAmount;

	// 运费金额
	@Column
	private Double freightAmount;

	// 可以活动的成长值
	@Column
	private Integer growth;

	// 订单id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 可以获得的积分
	@Column
	private Integer integration;

	// 积分抵扣金额
	@Column
	private Double integrationAmount;

	// 用户帐号
	//@Id
	private Long memberId;
	@Column
	private String memberUsername;

	// 修改时间
	@Column
	private String modifyTime;

	// 订单备注
	@Column
	private String note;

	// 订单编号
	@Column
	private String orderSn;

	// 订单类型：0->正常订单；1->秒杀订单
	@Column
	private Integer orderType;

	// 应付金额（实际支付金额）
	@Column
	private Double payAmount;

	// 支付方式：0->未支付；1->支付宝；2->微信
	@Column
	private Integer payType;

	// 支付时间
	@Column
	private String paymentTime;

	// 促销优化金额（促销价、满减、阶梯价）
	@Column
	private Double promotionAmount;

	// 活动信息
	@Column
	private String promotionInfo;

	// 确认收货时间
	@Column
	private String receiveTime;

	// 城市
	@Column
	private String receiverCity;

	// 详细地址
	@Column
	private String receiverDetailAddress;

	// 收货人姓名
	@Column
	private String receiverName;

	// 收货人电话
	@Column
	private String receiverPhone;

	// 收货人邮编
	@Column
	private String receiverPostCode;

	// 省份/直辖市
	@Column
	private String receiverProvince;

	// 区
	@Column
	private String receiverRegion;

	// 订单来源：0->PC订单；1->app订单
	@Column
	private Integer sourceType;

	// 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
	@Column
	private Integer status;

	// 订单总金额
	@Column
	private Double totalAmount;

	// 下单时使用的积分
	@Column
	private Integer useIntegration;
}
