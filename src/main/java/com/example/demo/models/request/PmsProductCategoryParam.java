package com.example.demo.models.request;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PmsProductCategoryParam {
	// 描述
	private String description;

	// 图标
	private String icon;

	// 关键字
	private String keywords;

	// 商品分类名称
	private String name;

	// 是否在导航栏显示
	private Integer navStatus;

	// 父分类的编号
	private Long parentId;

//	// 产品相关筛选属性集合
//	private List<> productAttributeIdList;

	// 分类单位
	private String productUnit;

	private Integer showStatus;

	// 排序
	private Integer sort;

}
