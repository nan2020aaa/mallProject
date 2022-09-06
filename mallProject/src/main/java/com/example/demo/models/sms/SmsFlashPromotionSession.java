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
public class SmsFlashPromotionSession {
	// 创建时间
	@Column
	private Date createTime;

	// 每日结束时间
	@Column
	private Date endTime;

	// 编号
	@Id
	private Long id;

	// 场次名称
	@Column
	private String name;

	// 每日开始时间
	@Column
	private Date startTime;

	// 启用状态：0->不启用；1->启用
	@Column
	private Integer status;
}
