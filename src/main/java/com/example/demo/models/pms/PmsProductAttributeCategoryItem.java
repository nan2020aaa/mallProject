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
public class PmsProductAttributeCategoryItem {
	// 属性数量
	private Integer attributeCount;

	private Long id;

	private String name;

	// 参数数量
	private Integer paramCount;

	private List<PmsProductAttribute> productAttributeList;

}
