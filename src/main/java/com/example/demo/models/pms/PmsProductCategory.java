package com.example.demo.models.pms;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.models.response.CommonResult.CommonResultBuilder;

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

	// 分类级别：0->1级；1->2级
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Id
	private Long id;
	@Column
	private String keywords;
	@Column
	private Integer level;

	// 是否显示在导航栏：0->不显示；1->显示
	@Column
	private String name;
	@Column
	private Integer navStatus;

	// 上机分类的编号：0表示一级分类
	@Column
	private Long parentId;

	// 显示状态：0->不显示；1->显示
	@Column
	private Integer productCount;
	@Column
	private String productUnit;
	@Column
	private Integer showStatus;

	@Column
	private Integer sort;

}
