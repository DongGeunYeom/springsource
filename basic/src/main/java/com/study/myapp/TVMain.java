package com.study.myapp;

public class TVMain {

	public static void main(String[] args) {
//		TV tv = new SamsungTV(new SonySpeaker());
		
		SamsungTV tv = new SamsungTV();
		
//		tv.setSpeaker(new SonySpeaker());
		tv.setSpeaker(new AppleSpeaker());
		
		tv.powerOn();
		tv.volumeUp();
		tv.poweroff();
		
//		String str = null;
//		System.out.println(str);
//		System.out.println(str.toString());
		
	}
}
