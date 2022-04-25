package com.study.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.myapp.dto.BookDTO;
import com.study.myapp.service.BookService;

public class BookMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService service = (BookService) ctx.getBean("service");
		
		// 자바코드
//		BookService service = new BookServiceImpl();
//		List<BookDTO> list = service.getList();
	
//		// 도서 정보 삽입
//		BookDTO insertDto = new BookDTO(2002, "배그가 대세다", "배그우리", 24500);
//		System.out.println(service.bookInsert(insertDto)?"삽입성공":"삽입실패");
//		
	
		
		// 도서 정보 수정
//		System.out.println(service.bookUpdate(2002, 32000)?"수정성공":"수정실패");
//		System.out.println(service.bookDelete(2002)?"삭제성공":"삭제실패");
		
		List<BookDTO> list = service.searchList("code", "1001");
		for(BookDTO dto:list) {
			System.out.println(dto);
		}
	}

}
