package com.example.demo.models.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.models.request.PmsProductParam;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CmsSubjectProductRelation {
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "productParam_id")
//	private PmsProductParam productParam;
	
	@Id
	private Long id;
	@Column
	private Long productId;
	@Column
	private Long subjectId;
}
