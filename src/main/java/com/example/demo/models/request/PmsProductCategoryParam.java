package com.example.demo.models.request;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Entity
public class PmsProductCategoryParam {
	// 描述
	//@Column
	private String description;

	// 图标
	//@Column
	private String icon;

	// 关键字
	//@Column
	private String keywords;

	// 商品分类名称
	//@Column
	private String name;

	// 是否在导航栏显示
	//@Column
	private Integer navStatus;

	// 父分类的编号
	//@Id
	private Long parentId;

	// 产品相关筛选属性集合
	//@Column
	private List<Long> productAttributeIdList;

	// 分类单位
	//@Column
	private String productUnit;

	//@Column
	private Integer showStatus;

	// 排序
	//@Column
	private Integer sort;

}
