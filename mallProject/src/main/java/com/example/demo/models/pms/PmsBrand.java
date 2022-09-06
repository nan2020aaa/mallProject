package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PmsBrand {
	//专区大图
	@Column
	private String bigPic;
	
	//品牌故事
	@Column 
	private String brandStory;
	
	//是否为品牌制造商：0->不是；1->是
	@Column 
	private Integer factoryStatus;
	
	//首字母
	@Column 
	private String firstLetter;
	
	//品牌logo
	@Id
	private Long id;
	@Column 
	private String logo;
	
	//产品评论数量
	@Column 
	private String name;
	@Column 
	private Integer productCommentCount;
	
	//产品数量
	@Column 
	private Integer productCount;
	
	@Column 
	private Integer showStatus;
	@Column 
	private Integer sort;
	
	
	
	
	
	
	
	
	

}
