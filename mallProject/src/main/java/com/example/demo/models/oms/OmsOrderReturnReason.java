package com.example.demo.models.oms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OmsOrderReturnReason {
	//添加时间
	@Column
	private String createTime;

	//退货类型
	@Id
	private Long id;
	@Column
	private String name;

	//状态：0->不启用；1->启用
	@Column
	private Integer sort;
	@Column
	private Integer status;
}
