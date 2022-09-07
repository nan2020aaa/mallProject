package com.example.demo.models.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@Entity
public class CmsPrefrenceArea {
	//展示图片
	//@Id
	private Long id;
	//@Column
	private String name;
	//@Column
	private String pic;
	
	//@Column
	private Integer showStatus;
	//@Column
	private Integer sort;
	//@Column
	private String subTitle;

}
