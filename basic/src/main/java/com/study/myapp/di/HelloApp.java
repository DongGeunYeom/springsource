package com.study.myapp.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		System.out.println("---- 컨테이너 구동 전 ----");
		
		// 스프링 컨테이너 구동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		System.out.println("---- 컨테이너 구동 후 ----");

		// 스프링 컨테이너가 관리하는 객체 중 msg를 요청
		Message msg = (Message) ctx.getBean("ko");
		msg.sayHello("홍길동");
		
		
	}

}
 