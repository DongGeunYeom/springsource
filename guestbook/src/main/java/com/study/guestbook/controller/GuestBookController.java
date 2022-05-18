package com.study.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.dto.PageResultDTO;
import com.study.guestbook.entity.Guestbook;
import com.study.guestbook.service.GuestbookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestbookService service;
	
	@GetMapping({"/","/list"})
	public String list(PageRequestDTO requestDto, Model model) {
		log.info("list 요청");
	
		// 목록 리스트 생성 - PageResultDTO<GuestbookDTO, Guestbook>
		model.addAttribute("result", service.getList(requestDto));
		
		return "/guestbook/list";
	}
	
}
