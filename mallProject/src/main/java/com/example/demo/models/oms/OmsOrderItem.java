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
public class OmsOrderItem {
	//优惠券优惠分解金额
	@Column
	private Number couponAmount;

	//积分优惠分解金额
	@Column
	private Integer giftGrowth;
	@Column
	private Integer giftIntegration;
	@Id
	private Long id;
	@Column
	private Number integrationAmount;

	//订单id
	@Id
	private Long orderId;

	//订单编号
	@Column
	private String orderSn;

	//商品销售属性:[{'key':'颜色','value':'颜色'},{'key':'容量','value':'4G'}]
	@Column
	private String productAttr;

	//商品分类id
	@Column
	private String productBrand;
	@Id
	private Long productCategoryId;

	//销售价格
	@Id
	private Long productId;
	@Column
	private String productName;
	@Column
	private String productPic;
	@Column
	private Number productPrice;

	//购买数量
	@Column
	private Integer productQuantity;

	//商品sku条码
	@Column
	private String productSkuCode;

	//商品sku编号
	@Id
	private Long productSkuId;

	//商品促销分解金额
	@Column
	private String productSn;
	@Column
	private Number promotionAmount;

	//商品促销名称
	@Column
	private String promotionName;

	//该商品经过优惠后的分解金额
	@Column
	private Number realAmount;
}
