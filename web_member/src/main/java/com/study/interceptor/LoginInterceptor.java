package com.study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.study.dto.AuthDTO;

public class LoginInterceptor implements HandlerInterceptor {
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// /member/changePwd 요청시 세션 정보가 있는지 확인
//		HttpSession session = request.getSession();
//		AuthDTO authDto = (AuthDTO) session.getAttribute("login");
//		
//		if(authDto!=null) {
//			return true;
//		}
//		
//		response.sendRedirect("/member/signin");
//		return false;
//	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle");
	}
}
