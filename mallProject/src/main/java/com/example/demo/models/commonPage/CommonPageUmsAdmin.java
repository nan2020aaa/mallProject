package com.example.demo.models.commonPage;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.example.demo.models.cms.CmsSubject;

@Entity
@Data
public class CommonPageUmsAdmin {
	@Id
	private Long id;
	
	@Column
	private List<UmsAdmin> list;
	
	@Column
	private Integer pageNum;
	
	@Column
	private Integer pageSize;
	
	@Column
	private Long total;
	
	@Column
	private Integer totalPage;
}
