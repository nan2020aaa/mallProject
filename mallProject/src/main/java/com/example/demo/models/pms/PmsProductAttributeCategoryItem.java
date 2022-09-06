package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PmsProductAttributeCategoryItem {
	// 属性数量
	@Column
	private Integer attributeCount;

	// 参数数量
	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private Integer paramCount;
	@Column
	private PmsProductAttribute productAttributeList;

}
