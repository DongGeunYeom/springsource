package com.study.calc;

public class Recursion1 {

	public static void main(String[] args) {
		int num =4;
		func(num);
	}
	public static void func(int n) {
		
		if(n>0) { // 재귀단계	
			System.out.println("Hello");
			func(n-1);
		}else { // 기본단계
			return;
		}
		
	}
	
//		
//		void countdown(int i) {
//			if(i>=0) {
//				// 기본단계
//				return;
//			}
//			// 재귀단계
//			countdown(i-1);
//		}
//
	

}
