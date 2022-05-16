package com.study.board.service;

import java.util.List;

import com.study.board.dto.AttachDTO;
import com.study.board.dto.BoardDTO;
import com.study.board.dto.Criteria;

public interface BoardService {
	public List<BoardDTO> getList(Criteria cri);
	public void write(BoardDTO insertDto);
	public BoardDTO getOne(int bno);
	public boolean modify(BoardDTO updateDto);
	public boolean remove(int bno);
	public int getTotalCnt(Criteria cri);
	
	// 첨부파일
	public List<AttachDTO> attachList(int bno);
}
