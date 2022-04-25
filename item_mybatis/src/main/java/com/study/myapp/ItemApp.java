package com.study.myapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.dto.ItemDTO;
import com.study.service.ItemService;

public class ItemApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		ItemService service = (ItemService) ctx.getBean("service");
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while(flag) {
			System.out.println("---------------------------");
			System.out.println("1. 아이템 추가");
			System.out.println("2. 아이템 조회");
			System.out.println("3. 아이템 삭제");
			System.out.println("4. 아이템 수정");
			System.out.println("5. 아이템 전체 조회");
			System.out.println("---------------------------");
			
			System.out.print("메뉴:");
			int no = Integer.parseInt(sc.nextLine());
			
			switch(no) {
			case 1:
				ItemDTO insertDto = new ItemDTO();
				System.out.print("카테고리 : ");
				insertDto.setCategory(sc.nextLine());
				System.out.print("이름 : ");
				insertDto.setName(sc.nextLine());		
				System.out.print("설명 : ");
				insertDto.setContent(sc.nextLine());
				System.out.print("사이즈 : ");
				insertDto.setPsize(sc.nextLine());
				System.out.print("가격 : ");
				insertDto.setPrice(Integer.parseInt(sc.nextLine()));
				System.out.println(service.itemInsert(insertDto)?"아이템등록성공":"아이템등록실패"); 
				break;
			case 2:
				System.out.print("등록번호 : ");
				int num = Integer.parseInt(sc.nextLine());
				ItemDTO dto = service.getRow(num);
				System.out.print(dto.getNum()+"\t");
				System.out.print(dto.getCategory()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getContent()+"\t");
				System.out.print(dto.getPsize()+"\t");
				System.out.println(dto.getPrice());
				break;
			case 3:
				System.out.print("등록번호 : ");
				num = Integer.parseInt(sc.nextLine());
				System.out.println(service.itemDelete(num)?"삭제성공":"삭제실패");
				break;
			case 4:
				System.out.print("등록번호 : ");
				num = Integer.parseInt(sc.nextLine());
				System.out.print("사이즈 : ");
				String size = sc.nextLine();
				System.out.print("가격 : ");
				int price = Integer.parseInt(sc.nextLine());
				System.out.println(service.itemUpdate(num, size, price)?"수정성공":"수정실패");
				break;
			case 5:
				List<ItemDTO> list = service.getList();
				for(ItemDTO dto1:list) {
					System.out.print(dto1.getNum()+"\t");
					System.out.print(dto1.getCategory()+"\t");
					System.out.print(dto1.getName()+"\t");
					System.out.print(dto1.getContent()+"\t");
					System.out.print(dto1.getPsize()+"\t");
					System.out.println(dto1.getPrice());
				}
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				break;	
			}
			
		}
	}
}
