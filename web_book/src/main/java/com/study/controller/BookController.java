package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BookDTO;
import com.study.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book/*")
public class BookController {
	
	@Autowired
	private BookService service;
	
	//전체리스트
	@GetMapping("/list")
	public void list(Model model) {
		log.info("도서 전체 목록 요청");
		List<BookDTO> list = service.getlist();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/insert")
	public void insertGet() {
		log.info("insert.jsp 요청");
	}
	
	@PostMapping("/insert")
	public String insertPost(BookDTO insertDto, RedirectAttributes rttr) {
		log.info("도서 입력 요청"+insertDto);
		
		try {
			if(service.bookInsert(insertDto)) {
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "코드를 확인하세요.");
			return "redirect:/book/insert";
		}
		return "redirect:/book/insert";
	}
	

	@GetMapping("/delete")
	public void deleteGet() {
		log.info("delete.jsp 요청");
	}
	

	@PostMapping("/delete")
	public String deletePost(int code, RedirectAttributes rttr) {
		log.info("delete.service 요청"+code);
		
		try {
			if(service.bookDelete(code)) {
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "코드를 확인하세요.");
			return "redirect:/book/delete";
		}
		return "redirect:/book/delete";
	}	
	
	@GetMapping("/update")
	public void updateGet() {
		log.info("update.jsp 요청");
	}
	
	@PostMapping("/update")
	public String updatePost(int code, int price, RedirectAttributes rttr) {
		log.info("update.service 요청"+code+" "+price);
		
		try {
			if(service.bookUpdate(code, price)) {
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "코드를 확인하세요.");
			return "redirect:/book/update";
		}
		return "redirect:/book/update";
	}
}
