package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PmsProductAttributeValue {
	// 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
	@Id
	private Long id;
	
	@Column
	private Long productAttributeId;
	
	@Column
	private Long productId;
	
	@Column
	private String value;

}
