package com.study.myapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.study.myapp.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(BoardDTO insertDto) {
		
		String sql = "insert into spring_board(bno, title, content, writer) values(seq_board.nextval,?,?,?)";
		int result = jdbcTemplate.update(sql, insertDto.getTitle(),insertDto.getContent(), insertDto.getWriter());
	
		return result;
	}
	
	
	public List<BoardDTO> select(){
		
		String sql = "select * from spring_board";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
	
	// update - bno 일치하면 title, content, updatedate
	
	public int update(BoardDTO updateDto) {
		
		String sql = "update spring_board set title=?, content=?, updatedate = sysdate where bno=?";
		int result = jdbcTemplate.update(sql, updateDto.getTitle(), updateDto.getContent(), updateDto.getBno());
		return result;
	}
	
	public int delete(int bno) {
		
		String sql = "delete from spring_board where bno=?";
		
		return jdbcTemplate.update(sql, bno);
	}
	
	public BoardDTO selectOne(int bno) {
		
		String sql = "select * from spring_board where bno=?";
		
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
	}
}
