package com.example.demo.models.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CmsSubject {
	//画册图片用逗号分割
	@Column
	private String albumPics;
	
	//专题分类名称
	@Id
	private Long categoryId;
	@Column
	private String categoryName;
	
	//转发数
	@Column
	private Integer collectCount;
	@Column
	private Integer commentCount;
	@Column
	private String content;
	@Column
	private String createTime;
	@Column
	private String description;
	@Column
	private Integer forwardCount;
	
	//专题主图
	@Id
	private Long id;
	@Column
	private String pic;
	
	//关联产品数量
	@Column
	private Integer productCount;
	
	//显示状态：0->不显示；1->显示
	@Column
	private Integer readCount;
	@Column
	private Integer recommendStatus;
	@Column
	private Integer showStatus;
	
	@Column
	private String title;
	

}
