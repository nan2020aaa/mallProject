package com.example.demo.models.request;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@Entity
public class PmsBrandParam {
	// 品牌大图
	//@Column
	private String bigPic;

	// 品牌故事
	//@Column
	private String brandStory;

	// 是否为厂家制造商
	//@Column
	private Integer factoryStatus;

	// 品牌首字母
	//@Column
	private String firstLetter;

	// 品牌logo
	//@Column
	private String logo;

	// 品牌名称
	//@Column
	private String name;

	// 是否进行显示
	//@Column
	private Integer showStatus;

	// 排序字段
	//@Column
	private Integer sort;
}
