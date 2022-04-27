package com.study.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@GetMapping("/login")
	public void login() {
		log.info("login...");

	}
	
//	@PostMapping("/login")
//	public void loginPost(HttpServletRequest request) {
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String addr = request.getParameter("addr");
//		String age = request.getParameter("age");
//		log.info("login POST... "+userid+" "+password+" " +addr+" "+age);
//	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("user") UserDTO userDto) {
		log.info("login POST... "+userDto.getUserid()+" "+userDto.getPassword()+" "+userDto.getAddr()+" "+userDto.getAge());
		
		return "sample/logout";
		// return "home"; - forward
		//        "redirect:" sendRedirect
		// return "redirect:/"; // 가야할 경로(get 방식)
	}
	
	
}
