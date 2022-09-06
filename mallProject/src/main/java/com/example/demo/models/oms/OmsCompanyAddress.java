package com.example.demo.models.oms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OmsCompanyAddress {

	//地址名称
	@Column
	private String addressName;
	
	//市
	@Column
	private String city;

	//详细地址
	@Column
	private String detailAddress;

	//收发货人姓名
	@Id
	private Long id;
	@Column
	private String name;

	//收货人电话
	@Column
	private String phone;

	//省/直辖市
	@Column
	private String province;

	//是否默认收货地址：0->否；1->是
	@Column
	private Integer receiveStatus;

	//区
	@Column
	private String region;

	//默认发货地址：0->否；1->是
	@Column
	private Integer sendStatus;
	
}
