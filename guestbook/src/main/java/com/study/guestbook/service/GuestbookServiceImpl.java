package com.study.guestbook.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.dto.PageResultDTO;
import com.study.guestbook.entity.Guestbook;
import com.study.guestbook.repository.GuestbookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GuestbookServiceImpl implements GuestbookService {

	@Autowired
	private GuestbookRepository repository;
	
	@Override
	public Long register(GuestbookDTO insertDto) {
		log.info("등록 요청 "+insertDto);
		
		// entity 변환
		Guestbook entity = dtoToEntity(insertDto);
		
		log.info("entity "+entity);
		
		// DB 작업
		repository.save(entity);
		
		return entity.getGno();
	}

	@Override
	public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDto) {
		
		// sort 기준
		Pageable pageable = requestDto.getPageable(Sort.by("gno").descending());
		
		// findAll 호출
		Page<Guestbook> result= repository.findAll(pageable);
		Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
		
		return new PageResultDTO<GuestbookDTO, Guestbook>(result, fn);
	}

}
