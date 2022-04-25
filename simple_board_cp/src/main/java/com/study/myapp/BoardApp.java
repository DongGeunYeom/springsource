package com.study.myapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.myapp.dto.BoardDTO;
import com.study.myapp.service.BoardService;

public class BoardApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BoardService service = (BoardService) ctx.getBean("service");
		
//		// 게시글 등록
//		BoardDTO insertDto = new BoardDTO();
//		insertDto.setTitle("스프게시판");
//		insertDto.setContent("스프게시판작성하기");
//		insertDto.setWriter("둘");
//		
//		System.out.println(service.boardInsert(insertDto)?"삽입성공":"삽입실패");
//		
		// 게시글 수정
//		BoardDTO updateDto = new BoardDTO();
//		updateDto.setBno(1);
//		updateDto.setTitle("테트리스게시판");
//		updateDto.setContent("테트리스게시판작성하기");
//				
//		System.out.println(service.boardUpdate(updateDto)?"수정성공":"수정실패");
//		
//		//게시글 목록
		List<BoardDTO> list = service.getList();
		for(BoardDTO dto:list) {
			System.out.println(dto);
		}
//		
//		int bno = 1;
//		System.out.println(service.boardDelete(bno)?"삭제성공":"삭제실패");		
		
		// 게시글 조회
//		System.out.println(service.getRow(3));
		
	}
}
