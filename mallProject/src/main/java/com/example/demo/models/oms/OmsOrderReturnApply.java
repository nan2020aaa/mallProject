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
public class OmsOrderReturnApply {
	// 收货地址表id
	@Id
	private Long companyAddressId;

	// 申请时间
	@Column
	private String createTime;

	// 描述
	@Column
	private String description;

	// 处理人员
	@Column
	private String handleMan;

	// 处理备注
	@Column
	private String handleNote;

	// 处理时间
	@Column
	private String handleTime;

	// 会员用户名
	@Id
	private Long id;
	@Column
	private String memberUsername;

	// 订单id
	@Id
	private Long orderId;

	// 订单编号
	@Column
	private String orderSn;

	// 商品销售属性：颜色：红色；尺码：xl;
	@Column
	private String productAttr;

	// 商品品牌
	@Column
	private String productBrand;

	// 退货数量
	@Column
	private Integer productCount;

	// 退货商品id
	@Id
	private Long productId;

	// 商品名称
	@Column
	private String productName;

	// 商品图片
	@Column
	private String productPic;

	// 商品单价
	@Column
	private Double productPrice;

	// 商品实际支付单价
	@Column
	private Double productRealPrice;

	// 凭证图片，以逗号隔开
	@Column
	private String proofPics;

	// 原因
	@Column
	private String reason;

	// 收货人
	@Column
	private String receiveMan;

	// 收货备注
	@Column
	private String receiveNote;

	// 收货时间
	@Column
	private String receiveTime;

	// 退款金额
	@Column
	private Double returnAmount;

	// 退货人姓名
	@Column
	private String returnName;

	// 退货人电话
	@Column
	private String returnPhone;

	// 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
	@Column
	private Integer status;
}
