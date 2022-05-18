package com.study.guestbook.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
// 화면에서 전달되는 목록 데이터
// 페이지 번호, 페이지 내 보여줄 목록 수, 검색타입, 검색어 ==? Criteria 비슷한 객체
public class PageRequestDTO {
	
	private int page; // 현재 페이지 번호
	private int size; // 페이지 내 보여줄 목록 수 
	
	public PageRequestDTO() {
		this.page = 1;
		this.size = 10;
	}
	
	public Pageable getPageable(Sort sort) {
		// 시작페이지가 0이기 때문에
		return PageRequest.of(page-1, size, sort);
	}

}
