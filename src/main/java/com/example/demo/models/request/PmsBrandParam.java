package com.example.demo.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PmsBrandParam {
	// 品牌大图
	private String bigPic;

	// 品牌故事
	private String brandStory;

	// 是否为厂家制造商
	private Integer factoryStatus;

	// 品牌首字母
	private String firstLetter;

	// 品牌logo
	private String logo;

	// 品牌名称
	private String name;

	// 是否进行显示
	private Integer showStatus;

	// 排序字段
	private Integer sort;
}
