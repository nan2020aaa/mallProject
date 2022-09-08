package com.example.demo.models.sms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data
//@NoArgsConstructor
public class SmsHomeRecommendSubject {
	//@Id
	private Long id;
	//@Column
	private Integer recommendStatus;
	//@Column
	private Integer sort;
	//@Id
	private Long subjectId;
	//@Column
	private String subjectName;
}
