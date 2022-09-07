package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmsHomeBrand {
	@Id
	private Long brandId;
	@Column
	private String brandName;
	@Id
	private Long id;
	@Column
	private Integer recommendStatus;
	@Column
	private Integer sort;

}
