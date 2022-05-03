package com.study.service;

import org.apache.ibatis.annotations.Param;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;

public interface MemberService {
	//회원가입
	public boolean signIn(MemberDTO regDto);
	public AuthDTO getIn(String userid, String password);
	public String dupId(String userid);
	public boolean modify(ChangeDTO upDto);
	public boolean leave(String userid, String password);
}
