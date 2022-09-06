package com.example.demo.models.sms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.models.oms.OmsOrderDetail;
import com.example.demo.models.oms.OmsOrderItem;
import com.example.demo.models.oms.OmsOrderOperateHistory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmsFlashPromotion {
	// 秒杀时间段名称
	@Column
	private Date createTime;

	// 结束日期
	@Column
	private Date endDate;

	// 开始日期
	@Id
	private Long id;
	@Column
	private Date startDate;

	// 上下线状态
	@Column
	private Integer status;

	@Column
	private String title;
}
