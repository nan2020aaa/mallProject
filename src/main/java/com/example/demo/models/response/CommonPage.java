package com.example.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonPage {

	private Object list;

	private Integer pageNum;

	private Integer pageSize;

	private Long total;

	private Integer totalPage;
}
