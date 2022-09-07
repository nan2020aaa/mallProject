package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@NoArgsConstructor
public class SmsFlashPromotion {
	// 秒杀时间段名称
	//@Column
	private String createTime;

	// 结束日期
	//@Column
	private String endDate;

	// 开始日期
	//@Id
	private Long id;
	//@Column
	private String startDate;

	// 上下线状态
	//@Column
	private Integer status;

	//@Column
	private String title;
}
