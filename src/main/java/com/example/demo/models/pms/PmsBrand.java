package com.example.demo.models.pms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class PmsBrand {
	// 专区大图
	@Column
	private String bigPic;

	// 品牌故事
	@Column
	private String brandStory;

	// 是否为品牌制造商：0->不是；1->是
	@Column
	private Integer factoryStatus;

	// 首字母
	@Column
	private String firstLetter;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	// 品牌logo
	@Column
	private String logo;

	// 产品评论数量
	@Column
	private String name;

	@Column
	private Integer productCommentCount;

	// 产品数量
	@Column
	private Integer productCount;

	@Column
	private Integer showStatus;

	@Column
	private Integer sort;
}
