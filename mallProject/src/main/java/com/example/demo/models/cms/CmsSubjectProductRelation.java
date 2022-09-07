package com.example.demo.models.cms;

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
	@Id
	private Long productId;
	@Id
	private Long subjectId;
}
