package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.dto.PageDTO;
import com.study.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// /board/list 컨트롤러
	@GetMapping("/list")
	public void listGet(@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("전체 리스트 요청");
		List<BoardDTO> list = service.getList(cri);
		int total = service.getTotalCnt();
		
		model.addAttribute("pageDto", new PageDTO(cri, total));
		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("register 폼 요청");
	}
	
	// post
	@PostMapping("/register")
	public String registerPost(BoardDTO insertDto, RedirectAttributes rttr) {
		log.info("글 작성 서비스 요청",insertDto);
		try {
			if(service.write(insertDto)) {
				rttr.addFlashAttribute("result", insertDto.getBno());
				return "redirect:/board/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/board/register";
		}
		return "redirect:/board/register";	
	}
	
	// /board/read + bno
	// bno에 해당하는 게시물 읽어온 후 read.jsp 보여주기
	@GetMapping({"/read","/modify"})
	public void readGet(int bno, Model model) {
		log.info("게시물 열람 요청 "+bno);
		BoardDTO dto = service.getOne(bno);
		
		model.addAttribute("dto", dto);
	}
	
	// /board/read + post => 수정 성공시 수정된 게시물 보여주기
	@PostMapping("/modify")
	public String modifyPost(BoardDTO updateDto, RedirectAttributes rttr) {
		log.info("게시물 수정 요청"+updateDto);
		try {
			if(service.modify(updateDto)) {
				rttr.addAttribute("bno", updateDto.getBno());
				return "redirect:/board/read";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/board/modify";
		} 
		return "redirect:/board/modify";
	}
	
	// /board/remove + bno / 성공시 list 보여주기
	
	@GetMapping("/remove")
	public String remove(int bno, RedirectAttributes rttr) {
		log.info("게시물 삭제 요청 "+bno);
		try {
			if(service.remove(bno)) {
				rttr.addFlashAttribute("result", "success");
				return "redirect:/board/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/board/modify";
		}
		return	"redirect:/board/modify";
	}
	
}
