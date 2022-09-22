package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class PmsProductAttribute {
	// 分类筛选样式：1->普通；1->颜色
	@Column
	private Integer filterType;

	// 是否支持手动新增；0->不支持；1->支持
	@Column
	private Integer handAddStatus;

	// 可选值列表，以逗号隔开
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String inputList;

	// 属性录入方式：0->手工录入；1->从列表中选取
	@Column
	private Integer inputType;

	// 相同属性产品是否关联；0->不关联；1->关联
	@Column
	private String name;

	@Column
	private Long productAttributeCategoryId;

	@Column
	private Integer relatedStatus;

	// 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
	@Column
	private Integer searchType;

	// 属性选择类型：0->唯一；1->单选；2->多选
	@Column
	private Integer selectType;

	// 排序字段：最高的可以单独上传图片
	@Column
	private Integer sort;

	// 属性的类型；0->规格；1->参数
	@Column
	private Integer type;
}
