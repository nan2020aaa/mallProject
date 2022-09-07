package com.example.demo.models.ums;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsMemberLevel {
	//每次评价获取的成长值
	@Column
	private Integer commentGrowthPoint;
	
	//是否为默认等级：0->不是；1->是
	@Column
	private Integer defaultStatus;
	
	//免运费标准
	@Column
	private Double freeFreightPoint;
	
	@Column
	private Integer growthPoint;
	
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String note;
	
	//是否有生日特权
	@Column
	private Integer priviledgeBirthday;
	
	//是否有评论获奖励特权
	@Column
	private Integer priviledgeComment;
	
	//是否有免邮特权
	@Column
	private Integer priviledgeFreeFreight;
	
	//是否有会员价格特权
	@Column
	private Integer priviledgeMemberPrice;
	
	//是否有专享活动特权
	@Column
	private Integer priviledgePromotion;
	
	//是否有签到特权
	@Column
	private Integer priviledgeSignIn;
}
