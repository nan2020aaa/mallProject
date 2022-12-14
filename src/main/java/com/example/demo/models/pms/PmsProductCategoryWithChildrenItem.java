package com.example.demo.models.pms;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class PmsProductCategoryWithChildrenItem {

	// 子级分类
	private List<PmsProductCategory> children;

	// 描述
	private String description;

	// 图标
	private String icon;

	private Long id;

	private String keywords;
	// 分类级别：0->1级；1->2级
	private Integer level;

	private String name;

	// 是否显示在导航栏：0->不显示；1->显示
	private Integer navStatus;

	// 上级分类的编号：0表示一级分类
	private Long parentId;

	private Integer productCount;
	private String productUnit;
	// 显示状态：0->不显示；1->显示
	private Integer showStatus;

	private Integer sort;
}
