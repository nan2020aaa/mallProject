package com.example.demo.models.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CmsSubjectProductRelation {
	@Id
	private Long id;
	@Column
	private Long productId;
	@Column
	private Long subjectId;
}
