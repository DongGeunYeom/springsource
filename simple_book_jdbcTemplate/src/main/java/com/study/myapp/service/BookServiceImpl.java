package com.study.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myapp.dao.BookDAO;
import com.study.myapp.dto.BookDTO;

@Service("service")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO dao;
	
	@Override
	public List<BookDTO> getList() {
		return dao.select();
	}
	
	public boolean bookInsert(BookDTO insertDto) {
		return dao.insert(insertDto) == 1?true:false;
	}

	@Override
	public boolean bookUpdate(int code, int price) {
		return dao.update(code, price)==1?true:false;
	}

	@Override
	public boolean bookDelete(int code) {
		return dao.delete(code)==1?true:false;
	}

}
