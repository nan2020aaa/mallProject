package com.example.demo.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OmsOrderParam {
	
	private Long id;
	private String orderSn;
	private String createTime;
	private String memberUsername;
	private Double totalAmount;
	private Integer payType;
	private Integer sourceType;
	private Integer status;
}
