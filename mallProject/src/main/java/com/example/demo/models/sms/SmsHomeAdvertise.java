package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmsHomeAdvertise {
	// 点击数
	@Column
	private Integer clickCount;

	// 备注
	@Column
	private String endTime;
	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private String note;

	// 下单数
	@Column
	private Integer orderCount;

	// 排序
	@Column
	private String pic;
	@Column
	private Integer sort;

	// 上下线状态：0->下线；1->上线
	@Column
	private String startTime;
	@Column
	private Integer status;

	// 轮播位置：0->PC首页轮播；1->app首页轮播
	@Column
	private Integer type;

	// 链接地址
	@Column
	private String url;
}
