package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Spring이 관리하지 않음

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class BookDTO {
	private int code;
	private String title;
	private String writer;
	private int price;
}
