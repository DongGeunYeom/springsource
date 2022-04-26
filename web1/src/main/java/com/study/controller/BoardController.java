package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@GetMapping("/list")
	public void list() {
		log.info("list...");
	}
	
//	@GetMapping("/modify")
//	public void modify() {
//		log.info("modify...");
//	}
//	
//	@GetMapping("/read")
//	public void read() {
//		log.info("read...");
//	}
	
	@GetMapping(path= {"/modify","/read"})
	public void readOrModify() {
		log.info("board modfiy or read 요청");
	}
	
	@GetMapping("/insert")
	public String insert() {
		log.info("insert...");
		return "board/insert";
	}

}
