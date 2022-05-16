package com.study.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.book.dto.BookDTO;

@Mapper
public interface BookMapper {
	
	//C(insert)R(read)U(update)D(delete) 작업 메소드 선언
	public List<BookDTO> list();
	public BookDTO select(int code);
	public List<BookDTO> search(@Param("criteria") String criteria,@Param("keyword")  String keyword);
	public int insert(BookDTO insertDto);
	public int update(@Param("code") int code,@Param("price") int price);
	public int delete(int code);
}
