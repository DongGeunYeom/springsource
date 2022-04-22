package com.study.myapp.di;

public class SamsungTV implements TV {
	
	//	private SonySpeaker speaker; // 초기화(생성자, setter 메소드)
	private Speaker speaker;
	
	public SamsungTV() {
		super();
	}

	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 On");
	}

	@Override
	public void poweroff() {
		System.out.println("SamsungTV 전원 Off");
	}

	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV Volume Up");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV Volume Down");
		speaker.volumeDown();
	}

}
