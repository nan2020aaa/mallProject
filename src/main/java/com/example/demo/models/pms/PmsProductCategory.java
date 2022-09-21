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
public class PmsProductCategory {
	// 描述
	@Column
	private String description;

	// 图标
	@Column
	private String icon;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String keywords;

	// 分类级别：0->1级；1->2级
	@Column
	private Integer level;

	@Column
	private String name;

	// 是否显示在导航栏：0->不显示；1->显示
	@Column
	private Integer navStatus;

	// 上级分类的编号：0表示一级分类
	@Column
	private Long parentId;

	@Column
	private Integer productCount;

	@Column
	private String productUnit;

	// 显示状态：0->不显示；1->显示
	@Column
	private Integer showStatus;

	@Column
	private Integer sort;
}
