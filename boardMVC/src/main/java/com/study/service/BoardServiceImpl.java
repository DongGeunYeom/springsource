package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.BoardDTO;
import com.study.dto.Criteria;
import com.study.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardDTO> getList(Criteria cri) {
		return mapper.listall(cri);
	}

	@Override
	public boolean write(BoardDTO insertDto) {
		return mapper.register(insertDto)==1?true:false;
	}

	@Override
	public BoardDTO getOne(int bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardDTO updateDto) {
		return mapper.update(updateDto)==1?true:false;
	}

	@Override
	public boolean remove(int bno) {
		return mapper.delete(bno)==1?true:false;
	}

	@Override
	public int getTotalCnt(Criteria cri) {
		return mapper.totalCnt(cri);
	}

}
