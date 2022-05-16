package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.board.dto.Criteria;
import com.study.board.dto.ReplyDTO;
import com.study.board.dto.ReplyPageDTO;

@Mapper
public interface ReplyMapper {
	public int insert(ReplyDTO insertDto);
	public ReplyDTO read(int rno);
	public int update(ReplyDTO updateDto);
	public int delete(int rno);
	public List<ReplyDTO> select(@Param("cri")Criteria cri, @Param("bno")int bno);
	public int getCountBno(int bno);
	public int deleteAll(int bno);
}
