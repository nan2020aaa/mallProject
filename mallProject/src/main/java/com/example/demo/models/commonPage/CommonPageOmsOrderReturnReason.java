package com.example.demo.models.commonPage;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.models.cms.CmsSubject;

import lombok.Data;

@Entity
@Data
public class CommonPageOmsOrderReturnReason {
	@Id
	private Long id;
	
	@Column
	private List<OmsOrderReturnReason> list;
	
	@Column
	private Integer pageNum;
	
	@Column
	private Integer pageSize;
	
	@Column
	private Long total;
	
	@Column
	private Integer totalPage;
}
