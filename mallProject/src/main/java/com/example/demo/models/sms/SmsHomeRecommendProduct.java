package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmsHomeRecommendProduct {
	@Id
	private Long id;
	@Id
	private Long productId;
	@Column
	private String productName;
	@Column
	private Integer recommendStatus;
	@Column
	private Integer sort;
}
