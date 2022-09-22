package com.example.demo.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PmsProductAttributeParam {
	// 分类筛选样式：0->普通；1->颜色
	private Integer filterType;

	// 是否支持手动新增；0->不支持；1->支持
	private Integer handAddStatus;

	// 可选值列表，以逗号隔开
	private String inputList;

	// 属性录入方式：0->手工录入；1->从列表中选取
	private Integer inputType;

	// 属性名称
	private String name;

	// 属性分类ID
	private Long productAttributeCategoryId;

	// 相同属性产品是否关联；0->不关联；1->关联
	private Integer relatedStatus;

	// 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
	private Integer searchType;

	// 属性选择类型：0->唯一；1->单选；2->多选
	private Integer selectType;

	private Integer sort;

	// 属性的类型；0->规格；1->参数
	private Integer type;
}
