package com.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;
import com.study.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//step1
	@GetMapping("/step1")
	public void getStep1() {
		log.info("step1.jsp 요청");
	}
	
	// http://localhost:9090/member/step2
	@PostMapping("/step2")
	public String step2(boolean agree, RedirectAttributes rttr) {
		log.info("Step2.jsp 요청"+agree);
		// 약관동의를 했다면 step2 페이지 보여주기
		// 안했다면 step1 되돌려보내기
		if(!agree) {
			rttr.addFlashAttribute("check", "false");
			return "redirect:/member/step1";
		}
		return "/member/step2";
	}
	
	// step2 post 요청 처리하는 컨트롤러 작성
	// 회원가입 서비스 호출
	// 회원가입 성공시 signin 보여주기
	@PostMapping("/regist")
	public String regist(MemberDTO regDto, RedirectAttributes rttr) {
		log.info("회원가입요청"+regDto);
		
		try {
			if(service.signIn(regDto)) {
				return "redirect:/member/signin"; // 로그인 페이지 이동
			}
		} catch (Exception e) {
			rttr.addFlashAttribute("error", "회원가입을 할 수 없습니다.");
			return "/member/step2"; // WEB-INF//views/member/step2.jsp 이동
		}
		return "/member/step2";
	}
	
	@GetMapping("/signin")
	public void signinGet() {
		log.info("로그인 폼 요청");
	}
	
	// 로그인 post => 로그인 성공시 index 보여주기
	@PostMapping("/signin")
	public String signinPost(String userid, String password, HttpSession session) {
		log.info("로그인 서비스 요청"+userid+" "+password);
		
		AuthDTO authDto = service.getIn(userid, password);
		
		if(authDto==null) {
			return "redirect:/member/signin"; // 로그인 실패시 다시 로그인 페이지
		}
		
		session.setAttribute("login", authDto);
		return "redirect:/";
	}

	// logout + get => session 해제 후 index 이동
	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		log.info("로그아웃 요청");
		session.invalidate();
		return "redirect:/";
	}
	
	// 비밀번호 변경 폼 요청하기
	@GetMapping("/changePwd")
	public void changeGet() {
		log.info("비밀번호 변경 폼 요청");
	}
	
	@PostMapping("/changePwd")
	public String changePost(ChangeDTO upDto, HttpSession session, RedirectAttributes rttr) {
		AuthDTO authDto = (AuthDTO)session.getAttribute("login");
		
		// 세션 userid ChangeDTO에 담기
		upDto.setUserid(authDto.getUserid());
		log.info("비밀번호 변경 서비스 요청"+upDto);
	
		// 현재 비밀번호 확인 // 일치 => 비밀번호 변경 / 불일치 => 비밀번호 변경폼으로 돌아가기
		if(service.getIn(upDto.getUserid(), upDto.getPassword())!=null) {
			if(upDto.getNew_password().equals(upDto.getConfirm_password())) {
				service.modify(upDto);
				session.invalidate();
				return "redirect:/member/signin";
			} else {
				rttr.addFlashAttribute("error", "바꿀 비밀번호가 일치하지 않습니다..");
				return "redirect:/member/changePwd";
			}
		} else {
			rttr.addFlashAttribute("error", "현재 비밀번호를 확인해 주세요.");
			return "redirect:/member/changePwd";
		}
	}
	
	// 탈퇴 폼 보여주기
	@GetMapping("/leave")
	public void leaveGet() {
		log.info("leave.jsp 요청");
	}
	
	@PostMapping("/leave")
	public String leavePost(String userid, @RequestParam("current_password") String password, HttpSession session, RedirectAttributes rttr) {
		log.info("leave service 요청"+userid+" "+password);
		
		if(service.leave(userid, password)) {
			session.invalidate();
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("error", "비밀번호가 일치하지 않습니다.");
			return "redirect:/member/leave";
		}	
	}
	
	// 중복 아이디검사
	@ResponseBody // 리턴하는 값이 jsp가 아님
	@PostMapping("/CheckId")
	public String checkId(String userid) {
		log.info("중복 아이디 검사 "+userid);
		
		//userid1 값이 있다면 중복, null이면 사용 가능
		if(service.dupId(userid)!=null) {
			return "false"; // jsp 페이지가 아님
		}
		return "true";
	}
	
}
