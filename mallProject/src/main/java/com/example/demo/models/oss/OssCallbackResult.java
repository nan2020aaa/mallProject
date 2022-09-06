package com.example.demo.models.oss;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class OssCallbackResult {
	//文件名称
	@Column
	private String filename;
	
	//图片文件的高
	@Column
	private String height;
	
	//文件的mimeType
	@Column
	private String mimeType;
	
	//文件大小
	@Column
	private String size;
	
	//图片文件的宽
	@Column
	private String width;
}

