package com.study.mapper;

import org.apache.ibatis.annotations.Param;

import com.study.dto.AuthDTO;
import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;

public interface MemberMapper {
	// CRUD	메소드 정의
	public int register(MemberDTO regDto);
	public AuthDTO login(@Param("userid") String userid, @Param("password") String password);
	public String dupId(String userid);
	public int update(ChangeDTO upDto);
	public int delete(@Param("userid") String userid, @Param("password") String password);
	
}
