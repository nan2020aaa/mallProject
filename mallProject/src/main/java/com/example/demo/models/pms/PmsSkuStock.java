package com.example.demo.models.pms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PmsSkuStock {
	// 锁定库存
	@Id
	private Long id;
	@Column
	private Integer lockStock;

	// 预警库存
	@Column
	private Integer lowStock;

	// 展示图片
	@Column
	private String pic;

	// 单品促销价格
	@Column
	private Double price;
	@Id
	private Long productId;
	@Column
	private Double promotionPrice;

	// 销量
	@Column
	private Integer sale;

	// sku编码
	@Column
	private String skuCode;

	// 商品销售属性，json格式
	@Column
	private String spData;

	// 库存
	@Column
	private Integer stock;
}
