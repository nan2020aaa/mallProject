package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@NoArgsConstructor
public class SmsFlashPromotionSession {
	// 创建时间
	//@Column
	private String createTime;

	// 每日结束时间
	//@Column
	private String endTime;

	// 编号
	//@Id
	private Long id;

	// 场次名称
	//@Column
	private String name;

	// 每日开始时间
	//@Column
	private String startTime;

	// 启用状态：0->不启用；1->启用
	//@Column
	private Integer status;
}
