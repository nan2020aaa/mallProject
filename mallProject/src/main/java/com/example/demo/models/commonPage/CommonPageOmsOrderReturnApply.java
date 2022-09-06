package com.example.demo.models.commonPage;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CommonPageOmsOrderReturnApply {
	@Id
	private Long id;
	
	@Column
	private List<OmsOrderReturnApply> list;
	
	@Column
	private Integer pageNum;
	
	@Column
	private Integer pageSize;
	
	@Column
	private Long total;
	
	@Column
	private Integer totalPage;
}
