package com.example.demo.models.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class CmsPrefrenceAreaProductRelation {
	@Id
	private Long id;
	
	@Column
	private Long prefrenceAreaId;
	
	@Column
	private Long productId;

}
